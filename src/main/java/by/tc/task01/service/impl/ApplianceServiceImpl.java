package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public List<Appliance> find(Criteria criteria, String groupSearchName) throws ParserConfigurationException, IOException, SAXException {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		List<Appliance> appliance = applianceDAO.find(criteria,groupSearchName);
		
		// you may add your own code here
		
		return appliance;
	}

	public void addNewPositionXML(Criteria criteria,String groupSearchName) throws ParserConfigurationException, IOException, SAXException {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		applianceDAO.addNewPositionXML(criteria,groupSearchName);
	}
}

//you may add your own new classes
