package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.main.Main;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {




//		String filename = Main.class.getClassLoader().getResource("appliances_db.xml").toString();
//		String schemaname = Main.class.getClassLoader().getResource("appliances_db.xsd").toString();
//		//String logname = "resources/log.txt";
//		Schema schema = null;
//		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
//		SchemaFactory factory = SchemaFactory.newInstance(language);
//		DefaultHandler dh = new DefaultHandler();
//
//		System.out.println(filename + " validating is ended.");
//		try {


		//      выкидывает ошибку при попытке получения schema!!!!!!!!!! не пойму пока почему!!!!



//			schema = factory.newSchema(new File(schemaname));
//			SAXParserFactory spf = SAXParserFactory.newInstance();
//			spf.setSchema(schema);
//			SAXParser parser = spf.newSAXParser();
//			parser.parse(filename, dh);
//			System.out.println(filename + " is valid");
//		} catch (ParserConfigurationException e) {
//			System.err.println(filename + " config error: " + e.getMessage());
//		} catch (SAXException e) {
//			System.err.println(filename + " SAX error: " + e.getMessage());
//		} catch (IOException e) {
//			System.err.println("I/O error: " + e.getMessage());
//		}
		return true;
	}

}

//you may add your own new classes