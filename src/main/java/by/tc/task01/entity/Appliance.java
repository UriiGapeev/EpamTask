package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Appliance {
	// you may add your own code here

      public List<SearchCriteria.AllAppliance> getParams(String nameAppliance) {
          List<SearchCriteria.AllAppliance> AllAppliance =new ArrayList<SearchCriteria.AllAppliance>(Arrays.asList(SearchCriteria.AllAppliance.values()));
          return AllAppliance;
      }

}
