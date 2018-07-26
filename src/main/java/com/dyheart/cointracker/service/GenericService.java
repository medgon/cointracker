package com.dyheart.cointracker.service;

import java.util.HashMap;
import java.util.List;

import com.dyheart.cointracker.dao.GenericDAO;
import com.dyheart.cointracker.dto.GroupDTO;

public interface GenericService<T> {
	abstract GenericDAO<T> getDAO();

    T updateFields(HashMap<String, Object> fieldsData, Long id) throws Exception;
    
    T getById(Long id) ;
    T getById(String id) ;

	List<T> search(String term) throws Exception;
	List<T> search(String term, List<String> fields) throws Exception;

	List<Object> buildGroups(List<?> objectList, List<GroupDTO> groupDTOList, Integer currentIndex) throws Exception;

}
