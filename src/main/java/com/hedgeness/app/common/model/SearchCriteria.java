package com.hedgeness.app.common.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class SearchCriteria {

	public static final String ORGANIZATIONID = "ORGNIZATIONID";
	public static final String PRIMARY_GROUPID = "PRIMARY_GROUPID";

	private Map searchFilterMap = new LinkedHashMap();

	public void add(String key, Object value) {
		searchFilterMap.put(key, value);
	}

	public Map getSearchFilterMap() {

		return searchFilterMap;

	}

	public Object getValue(String key) {

		return searchFilterMap.get(key);

	}

}
