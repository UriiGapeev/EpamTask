package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.sql.DriverManager.println;

public class TagHandler extends DefaultHandler {
    private StringBuilder text;
    private String testMenu;

    private List<Appliance> appliancesList = new ArrayList<Appliance>();
    private Oven oven;
    private Laptop laptop;

    List<SearchCriteria.Oven> paramEnumListOven =new ArrayList<SearchCriteria.Oven>(Arrays.asList(SearchCriteria.Oven.values()));;
    List<SearchCriteria.Laptop> paramEnumListLaptop =new ArrayList<SearchCriteria.Laptop>(Arrays.asList(SearchCriteria.Laptop.values()));;

    public  List<Appliance> getAppliancesList() {
        return appliancesList;
    }

    public void startDocument() throws SAXException {
        println("Parsing started.");
    }

    public void endDocument() throws SAXException {
        println("Parsing ended.");
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("library")) {
            testMenu = (String) attributes.getValue("typeinfo");
            if (testMenu.equals("Oven")) {
                oven = new Oven();
                oven.setId((Integer.parseInt(attributes.getValue("id"))));
                oven.setNameType(attributes.getValue("typeinfo"));
            }
            if (testMenu.equals("Laptop")) {
                laptop = new Laptop();
                laptop.setId((Integer.parseInt(attributes.getValue("id"))));
                laptop.setNameType(attributes.getValue("typeinfo"));
            }

        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (testMenu.equals("Oven")) {
            SearchCriteria.Oven tagName =
                    SearchCriteria.Oven.valueOf(qName.toUpperCase().replace("-"
                            , "_"));
            if (testMenu.equals("Oven")) {
                switch (tagName) {
                    case CAPACITY:
                        oven.setCapacity(Integer.parseInt(text.toString()));
                        break;
                    case DEPTH:
                        oven.setDepth(Integer.parseInt(text.toString()));
                        break;
                    case HEIGHT:
                        oven.setHeight(Double.parseDouble(text.toString()));
                        break;
                    case POWER_CONSUMPTION:
                        oven.setPowerConsumption(Integer.parseInt(text.toString()));
                        break;
                    case WEIGHT:
                        oven.setWeight(Integer.parseInt(text.toString()));
                        break;
                    case WIDTH:
                        oven.setWidth(Double.parseDouble(text.toString()));
                        break;
                    case LIBRARY:
                        oven.setParams(paramEnumListOven);
                        appliancesList.add(oven);
                        oven = null;
                        break;
                }
            }
        }
        if (testMenu.equals("Laptop")) {
            SearchCriteria.Laptop tagName =
                    SearchCriteria.Laptop.valueOf(qName.toUpperCase().replace("-"
                            , "_"));

            if (testMenu.equals("Laptop")) {
                switch (tagName) {
                    case CPU:
                        laptop.setCpu(Double.parseDouble(text.toString()));
                        break;
                    case BATTERY_CAPACITY:
                        laptop.setBatteryCapacity(Double.parseDouble(text.toString()));
                        break;
                    case DISPLAY_INCHS:
                        laptop.setDisplayInchs(Integer.parseInt(text.toString()));
                        break;
                    case MEMORY_ROM:
                        laptop.setMemoryRom(Integer.parseInt(text.toString()));
                        break;
                    case OS:
                        laptop.setOs(text.toString());
                        break;
                    case SYSTEM_MEMORY:
                        laptop.setSystemMemory(Integer.parseInt(text.toString()));
                        break;
                    case LIBRARY:
                        laptop.setParams(paramEnumListLaptop);
                        appliancesList.add(laptop);
                        laptop = null;
                        break;
                }
            }
        }
    }
}
