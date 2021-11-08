package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		List<Appliance> appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 32);
		criteriaOven.add(Oven.CAPACITY.toString(), 33);
		appliance = service.find(criteriaOven,criteriaOven.getGroupSearchName());

//		//////////////////////////////////////////////////////////////////
		Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
		criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
		criteriaLaptop.add(Laptop.OS.toString(), "Windows");
		appliance = service.find(criteriaLaptop,criteriaLaptop.getGroupSearchName());

		PrintApplianceInfo.print(appliance);

//		//////////////////////////////////////////////////////////////////
		Criteria criteriaOvenADD = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOvenADD.add(Oven.POWER_CONSUMPTION.toString(), 5000);
		criteriaOvenADD.add(Oven.WEIGHT.toString(), 55);
		criteriaOvenADD.add(Oven.CAPACITY.toString(), 55);
		criteriaOvenADD.add(Oven.DEPTH.toString(), 55);
		criteriaOvenADD.add(Oven.HEIGHT.toString(), 55);
		criteriaOvenADD.add(Oven.WIDTH.toString(), 55);

		service.addNewPositionXML(criteriaOvenADD,criteriaOvenADD.getGroupSearchName());

	}

}
