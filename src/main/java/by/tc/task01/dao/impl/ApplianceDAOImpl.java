package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO{
	ApplianceSearcher applianceSearcher = new ApplianceSearcher();
	ApplianceParser applianceParser = new ApplianceParser();
	ApplianceAddNewElementToXML applianceAddNewElementToXML = new ApplianceAddNewElementToXML();

	@Override
	public List<Appliance> find(Criteria criteria, String groupSearchName) throws ParserConfigurationException, IOException, SAXException {
		// you may add your own code here

		List<Appliance> appliance = applianceSearcher.searchLibraryList(criteria, applianceParser.parseAll(),groupSearchName);
		return appliance;
	}

	@Override
	public void addNewPositionXML(Criteria criteria,String groupSearchName) throws ParserConfigurationException, IOException, SAXException {
		applianceAddNewElementToXML.createXML(criteria,groupSearchName);
	}
	// you may add your own code here

}


//you may add your own new classes