package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliance) {
		// you may add your own code here
		System.out.println("Find element:");
		for (int i=0; i<appliance.size();i++) {
			System.out.println("String "+i+": "+appliance.get(i));
		}
	}

	// you may add your own code here

}
