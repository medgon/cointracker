package com.dyheart.cointracker.dto;
import java.util.List;


public class ResultSetDTO {
    private List<?> objectList;
    private Long count;
    private List<?> groups;

    public ResultSetDTO(){
    }

    public ResultSetDTO(Long count, List<?> objectList, List<?> group){
        this.objectList = objectList;
        this.count = count;
        this.groups = group;
    }

    public List<?> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public List<?> getObjectList(){
        return this.objectList;
    }

    public void setObjectList(List<Object> objectList){
        this.objectList = objectList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }


}

