package by.com.company.main;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;

public class MenuSaxHandler  extends DefaultHandler {

    private List<Food> foodList = new ArrayList<Food>();
    private Food food;
    private StringBuilder text;

    private List<Oven> ovenList = new ArrayList<Oven>();
    private Oven oven;

    private List<Laptop> laptopList = new ArrayList<Laptop>();
    private Laptop laptop;

    private String testMenu;
    public List<Food> getFoodList() {
        return foodList;
    }
    public List<Oven> getOvenList() {
        return ovenList;
    }
    public List<Laptop> getLaptopList() {
        return laptopList;
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
        if (qName.equals("food")){
            testMenu = (String) attributes.getValue("typeinfo");
            if(testMenu.equals("Oven")){
                oven = new Oven();
                oven.setId((Integer.parseInt(attributes.getValue("id"))));
                oven.setNameType(attributes.getValue("typeinfo"));
            }
            if(testMenu.equals("Laptop")){
                laptop = new Laptop();
                laptop.setId((Integer.parseInt(attributes.getValue("id"))));
                laptop.setNameType(attributes.getValue("typeinfo"));
            }

            //food = new Food();
            //food.setId((Integer.parseInt(attributes.getValue("id"))));
            //food.setNameType(attributes.getValue("typeinfo"));
        }
    }
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        MenuTagName tagName =
                MenuTagName.valueOf(qName.toUpperCase().replace("-"
                        , "_"));
        if(testMenu.equals("Oven")) {
            switch (tagName) {
                case NAME:
                    oven.setName(text.toString());
                    break;
                case PRICE:
                    oven.setPrice(text.toString());
                    break;
                case DESCRIPTION:
                    oven.setDescription(text.toString());
                    break;
                case CALORIES:
                    oven.setCalories(Integer.parseInt(text.toString()));
                    break;
                case FOOD:
                    ovenList.add(oven);
                    oven = null;
                    break;
            }
        }
        if(testMenu.equals("Laptop")) {
            switch (tagName) {
                case NAME:
                    laptop.setName(text.toString());
                    break;
                case PRICE:
                    laptop.setPrice(text.toString());
                    break;
                case DESCRIPTION:
                    laptop.setDescription(text.toString());
                    break;
                case CALORIES:
                    laptop.setCalories(Integer.parseInt(text.toString()));
                    break;
                case FOOD:
                    laptopList.add(laptop);
                    laptop = null;
                    break;
            }
        }
    }

}