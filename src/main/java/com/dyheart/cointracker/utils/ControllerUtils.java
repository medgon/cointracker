package com.dyheart.cointracker.utils;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dyheart.cointracker.domain.Coin;
import com.dyheart.cointracker.dto.FilterDTO;
import com.dyheart.cointracker.dto.GroupDTO;
import com.dyheart.cointracker.dto.SortDTO;

/**
 *
 * This class has helper methods generally used by Spring Controllers
 */
public class ControllerUtils {


    public static List<SortDTO> parseSortParams(HttpServletRequest request) {
        List<SortDTO> sortList = new ArrayList<SortDTO>();

        boolean loop = true;

        for (int i = 0; loop == true; i++) {
            String paramName = "sort[" + i + "][field]";
            String[] fieldValues = request.getParameterValues(paramName);

            if (fieldValues != null && fieldValues.length > 0) {
                paramName = "sort[" + i + "][dir]";
                String[] dirValues = request.getParameterValues(paramName);

                if (dirValues != null) {
                    SortDTO sort = new SortDTO(fieldValues[0]);
                    sort.setField(fieldValues[0]);
                    sort.setDir(dirValues[0]);

                    sortList.add(sort);
                }
            } else {
                loop = false;
            }
        }

        return sortList;
    }

    public static List<FilterDTO> parseFilterParams(HttpServletRequest request) {
        List<FilterDTO> filterList = new ArrayList<FilterDTO>();

        boolean loop = true;

        String paramName = "filter[logic]";
        String[] logicValues = request.getParameterValues(paramName);

        for (int i = 0; loop == true; i++) {
            paramName = "filter[filters][" + i + "][field]";
            String[] fieldValues = request.getParameterValues(paramName);

            if (fieldValues != null) {
                paramName = "filter[filters][" + i + "][operator]";
                String[] operValues = request.getParameterValues(paramName);

                paramName = "filter[filters][" + i + "][value]";
                String[] valValues = request.getParameterValues(paramName);

                if (logicValues != null && operValues != null && valValues != null) {
                    FilterDTO filter = new FilterDTO();

                    filter.setLogic(logicValues[0]);
                    filter.setField(fieldValues[0]);
                    filter.setOperator(operValues[0]);
                    filter.setValue(valValues[0]);

                    filterList.add(filter);
                }
            } else {
                loop = false;
            }
        }

        return filterList;
    }

    public static List<GroupDTO> parseGroupParams(HttpServletRequest request) {
        List<GroupDTO> groupList = new ArrayList<GroupDTO>();

        boolean loop = true;

        for (int i = 0; loop == true; i++) {
            String paramName = "group[" + i + "][field]";
            String[] fieldValues = request.getParameterValues(paramName);

            if (fieldValues != null && fieldValues.length > 0) {
                paramName = "group[" + i + "][dir]";
                String[] dirValues = request.getParameterValues(paramName);

                if (dirValues != null) {
                    GroupDTO group = new GroupDTO(fieldValues[0]);
                    group.setField(fieldValues[0]);
                    group.setDir(dirValues[0]);

                    groupList.add(group);
                }
            } else {
                loop = false;
            }
        }

        return groupList;
    }

}

