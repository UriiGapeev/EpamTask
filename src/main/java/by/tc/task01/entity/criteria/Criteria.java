package by.tc.task01.entity.criteria;

import by.tc.task01.dao.impl.ApplianceParam;

import java.util.*;

public class Criteria {

	private String groupSearchName;
	private Map<String, Object> criteria = new HashMap<String, Object>();
	private ApplianceParam applianceListParam = new ApplianceParam();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}
	
	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	public ApplianceParam getList(){

		for (Map.Entry<String, Object> entry : criteria.entrySet()) {
			applianceListParam.setKey(entry.getKey());
			applianceListParam.setParamValue(entry.getValue().toString());
		}

		return applianceListParam;

	}


	public Set<String> keySet() {return criteria.keySet();
	}

	public String get(String key) { return  criteria.get(key).toString();
	}
}
