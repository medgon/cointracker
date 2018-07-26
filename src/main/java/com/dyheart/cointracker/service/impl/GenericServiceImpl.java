package com.dyheart.cointracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dyheart.cointracker.dao.GenericDAO;
import com.dyheart.cointracker.dto.Group;
import com.dyheart.cointracker.dto.GroupDTO;
import com.dyheart.cointracker.service.GenericService;

@Service

@Transactional
public abstract class GenericServiceImpl<T> implements GenericService<T> {

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";// this is the date format we presently get from UI for scheduler

    private GenericDAO<T> genericDAO;
    
    public T getById(Long id) {
        genericDAO = getDAO();

        T t = genericDAO.find(id);
        return t;
    }

    public T getById(String id) {
        genericDAO = getDAO();

        T t = genericDAO.find(id);
        return t;
    }

    public T updateField(T myInstance, Long id, String field, String fieldType, Object newValue, Object previousValue) throws Exception {

        // use Spring's PropertyAccessor to get field data using reflection.  
        PropertyAccessor myAccessor = PropertyAccessorFactory.forBeanPropertyAccess(myInstance);

        try {
            Class<?> fieldTypeClass = myAccessor.getPropertyType(field);
            fieldType = fieldTypeClass.toString();
            previousValue = myAccessor.getPropertyValue(field);
            if (fieldTypeClass.isAssignableFrom(Date.class)) { // if we have a date, we need to convert the string value into a date before we try to update it.  
                String dateValue = newValue.toString();
                newValue = DateUtils.parseDate(dateValue, new String[] { DATE_FORMAT }); // this is the date format we presently get from UI for fund request
            }
        } catch (Exception e) {
            System.out.println("Could not determine field type.");
            e.printStackTrace();
        }

        myAccessor.setPropertyValue(field, newValue); // this line changes the actual attribute on the object in question

        return myInstance;
    }

    @Override
    public T updateFields(HashMap<String, Object> fieldsData, Long id) throws Exception {

        T myInstance = getById(id);// get the actual object here
        Set<String> keys = fieldsData.keySet(); // get all the keys in the map, which has all the changed fields

        keys.remove(id); // we always want to remove the ID as we should never change it

        // loop through the fields and update
        Iterator<String> i = keys.iterator();
        while (i.hasNext()) {
            String field = i.next();
            String fieldType = null;
            Object newValue = fieldsData.get(field);
            Object previousValue = null;

            updateField(myInstance, id, field, fieldType, newValue, previousValue);
        }
        // return the updated instance
        return myInstance;
    }
    
    //needs to be implemented and overriden in Concrete Class
	public List<T> search(String term) throws Exception {
		return new ArrayList<T>();
	}
	
    //needs to be implemented and overriden in Concrete Class
	public List<T> search(String term, List<String> fields) throws Exception {
		return new ArrayList<T>();
	}
	/**	
	 * 	Method is used to build a response consumed by KendoUI grid
	 *  More information about the response we build is for server side grouping can be found here:
	 *  
	 *  http://docs.telerik.com/kendo-ui/api/javascript/data/datasource#configuration-schema.groups
	 *  
	 * 
	 * @param objectList the "things" we want to put in groups
	 * @param groupDTOList contains the group list as send by KendoUI
	 * @param currentIndex always start from index 0. This is used by the recursive call to determine the level of grouping (how deep do we want to group the object)
	 * 
	 * @return groups it is an object which has nested grouping. See link above for Teleric documentation. We design this response for the KendoUI grid
	 * 
	 *  
	 **/
	public List<Object> buildGroups(List<?> objectList, List<GroupDTO> groupDTOList, Integer currentIndex) throws Exception {
		List<Object> groups = new ArrayList<Object>();
		
		// values is the values of what we are grouping by: for example if we group by Faculty Last Name the values are last names found in the result
		List<String> values = new ArrayList<String>(); 
		
		for (Object object : objectList) {
			
			//get the current field value of the current package
			String value = org.apache.commons.beanutils.BeanUtils.getProperty(object, groupDTOList.get(currentIndex).getField());
			
			if(!values.contains(value)) //don't add duplicates
				values.add(value);
		}
		
		for (String value : values){

			Group group = new Group();
			group.setAggregates(new HashMap<Object, Object>()); // currently we don't use Aggregates, we create an empty object
			group.setField(groupDTOList.get(currentIndex).getField()); // we set the field (see terelik doc above)
			group.setValue(value); // we set the value (see Terelik doc in above link)
			
			if((currentIndex + 1) >= groupDTOList.size()){ //we create groups which don't contain subgroups
				group.setHasSubgroups(false);
				
				List<Object> items = new ArrayList<Object>();
				for (Object object : objectList) {
					String fieldValue = org.apache.commons.beanutils.BeanUtils.getProperty(object, groupDTOList.get(currentIndex).getField());
					if(value == null && fieldValue == null){
						items.add(object); // if values are null, create a null group
					} else if ((value != null && fieldValue != null) && fieldValue.equals(value))  {
						items.add(object); // create group by property
					}
				}
				group.setItems(items);
			} else { // we create groups which have subgroups as items 
				group.setHasSubgroups(true);

				//filter List before calling the buildGroups method again. Only pass packages that have the values we are grouping by.
				List<Object> filteredList = new ArrayList<Object>();
				
				for (Object object : objectList) {
					String fieldValue = org.apache.commons.beanutils.BeanUtils.getProperty(object, groupDTOList.get(currentIndex).getField());
					if(value == null && fieldValue == null){
						filteredList.add(object); // if values are null, create a null group
					} else if ((value != null && fieldValue != null) && fieldValue.equals(value)) {
						filteredList.add(object); // else create group by property
					}
				}

				group.setItems(buildGroups(filteredList, groupDTOList, currentIndex+1)); //recursive call to the method
			}
			
			groups.add(group);
		}
		
		return groups;
	}

}

