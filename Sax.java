package by.com.company.main;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Sax {
        public Sax() {
        }

        public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
            String testMenu;
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            MenuSaxHandler handler = new MenuSaxHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource("src/main/resources/menu.xml"));
            //List<Food> technical = handler.getFoodList();
            //Iterator var7 = menu.iterator();

            List<Oven> menuOven = handler.getOvenList();
            Iterator varOven = menuOven.iterator();
            List<Laptop> menuLaptop = handler.getLaptopList();
            Iterator varLaptop = menuLaptop.iterator();
            /*while(var7.hasNext()) {
                Food food = (Food)var7.next();
                System.out.println(food.getName());
                System.out.println(food.getNameType());
            }*/
            while(varOven.hasNext()) {
                Oven oven = (Oven)varOven.next();
                System.out.println(oven.getDescription());
                System.out.println(oven.getNameType());
            }

            Scanner in = new Scanner(System.in);
            System.out.print("Input name: ");
            String name = in.nextLine();
            while(varLaptop.hasNext()) {
                Laptop laptop  = (Laptop)varLaptop.next();
                testMenu = (String)laptop.getDescription().toString();
                if(testMenu.equals(name)) {
                    System.out.println(laptop.getDescription());
                }else{
                    System.out.println("not found");
                }


            }


        }

    }
