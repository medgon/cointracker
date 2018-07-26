package com.dyheart.cointracker.dto;

import java.util.List;

public class Group {
	
	private Object aggregates;
	private String field; // the field by which the data items are grouped
	private boolean hasSubgroups;
	private List<?> items;
	private String value;
	
	public Group(Object aggregates, String field, boolean hasSubgroups, List<?> items, String value){
		this.aggregates = aggregates;
		this.field = field;
		this.hasSubgroups = hasSubgroups;
		this.items = items;
		this.value = value;
	}
	
	public Group() {
	}

	public Object getAggregates() {
		return aggregates;
	}
	public void setAggregates(Object aggregates) {
		this.aggregates = aggregates;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public boolean isHasSubgroups() {
		return hasSubgroups;
	}
	public void setHasSubgroups(boolean hasSubgroups) {
		this.hasSubgroups = hasSubgroups;
	}
	public List<?> getItems() {
		return items;
	}
	public void setItems(List<?> list) {
		this.items = list;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	} 
}