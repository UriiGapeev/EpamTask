package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class ApplianceSearcher {
    List<Appliance> findList = new ArrayList<Appliance>();
    List<ApplianceParam> paramList;
    List<SearchCriteria> params;
    public List<Appliance> searchLibraryList(Criteria criteria, List<Appliance> ApplianceList, String groupSearchName) {

        paramList = Collections.singletonList(criteria.getList());
        for (int i = 0; i < paramList.size(); i++) {
            String paramN = paramList.get(i).getKey().toUpperCase().toString();
            for (int j = 0; j < ApplianceList.size(); j++) {

                for (int z = 0; z < ApplianceList.get(i).getParams(groupSearchName).size(); z++) {
                    String paramM = ApplianceList.get(i).getParams(groupSearchName).get(z).toString();
                    String param111 = paramList.get(i).getParamValue().toString().toUpperCase();
                    String param222 = paramList.get(i).getKey().toString();
                    String param333 = ApplianceList.get(j).toString().toUpperCase();
                    if (paramN.equals(paramM)) {
                        if (param333.contains(param222 + "=" + param111) || param333.contains(param222 + "=" + "'" + param111 + "'")) {
                            if (findList.contains(ApplianceList.get(j))) {

                            } else {
                                findList.add(ApplianceList.get(j));
                            }
                        }
                    }
                }
            }
        }

        return findList;
    }
}
