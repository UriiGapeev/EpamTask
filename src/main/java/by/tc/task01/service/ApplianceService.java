package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface ApplianceService {	
	
	List<Appliance> find(Criteria criteria, String groupSearchName) throws ParserConfigurationException, IOException, SAXException;
	void addNewPositionXML(Criteria criteria,String groupSearchName) throws ParserConfigurationException, IOException, SAXException;
}
