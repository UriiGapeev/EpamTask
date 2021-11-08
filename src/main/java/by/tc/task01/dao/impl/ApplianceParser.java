package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.main.Main;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class ApplianceParser {
    private static final String XML_SOURCE_PATH = Main.class.getClassLoader().getResource("appliances_db.xml").toString();
    private List<Appliance> appliances;
    // вернуть распарсеннывй xml

    public List<Appliance> parseAll() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        TagHandler handler = new TagHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(XML_SOURCE_PATH));

        for (int i = 0; i < handler.getAppliancesList().size(); i++) {
            handler.getAppliancesList().get(i);
            appliances = handler.getAppliancesList();
        }

        return appliances;
    }

}
