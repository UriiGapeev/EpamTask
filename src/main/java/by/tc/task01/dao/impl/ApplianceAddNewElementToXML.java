package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.main.Main;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ApplianceAddNewElementToXML {

    public static void createXML(Criteria criteria, String groupSearchName) throws ParserConfigurationException, IOException, SAXException {
            ApplianceParser applianceParser = new ApplianceParser();
            List<Appliance> appliance  = applianceParser.parseAll();
            String name ;
            int quantityGroup= 0;

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            try {
                builder = factory.newDocumentBuilder();

                // создаем пустой объект Document, в котором будем
                // создавать наш xml-файл
                Document doc = builder.newDocument();
                // создаем корневой элемент
                Element rootElement =
                        doc.createElementNS("https://javadevblog.com/librarys", "librarys");
                // добавляем корневой элемент в объект Document
                doc.appendChild(rootElement);


                for (int i =0; i<appliance.size();i++){
                    name = null;
                    name = String.valueOf(appliance.get(i)).toUpperCase();
                    ArrayList<String> stringList = new ArrayList<String>();
                    for (String retval : name.split(",")) {
                        stringList.add(retval);

                    }
                    String secondElemOvenGet =null;
                    String firstElemID =null;
                    for (int z=0; z<stringList.size();z++) {
                        if (stringList.get(z).contains("ID=")) {
                            for (String retval : stringList.get(z).split("=")) {
                                if (retval.contains("ID")) {
                                    firstElemID = retval;
                                }
                            }
                        }
                        if (stringList.get(i).contains("NAMETYPE=")) {
                            for (String retval : stringList.get(i).split("=")) {
                                if (retval.contains("NAMETYPE")) {
                                } else {
                                    secondElemOvenGet = retval;
                                }
                            }

                        }

                    }
                    if(!stringList.get(1).contains("NAMETYPE="+"'"+groupSearchName.toString().toUpperCase()+"'")) {
                        quantityGroup = quantityGroup+1;
                        rootElement.appendChild(getLanguage(doc, Integer.toString(quantityGroup), groupSearchName.toString(), criteria));
                        rootElement.appendChild(getLanguage(doc, stringList));
                        quantityGroup = 0;
                    }
                          else{
                        quantityGroup = quantityGroup+1;
                        rootElement.appendChild(getLanguage(doc, stringList));
                    }


                }


                //создаем объект TransformerFactory для печати в консоль
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                // для красивого вывода в консоль
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);

                //печатаем в консоль или файл
                StreamResult file = new StreamResult(new File("D:\\EPAM JAVA\\jwd-task01-template_v2\\src\\main\\resources\\appliance_db_out.xml"));

                //записываем данные
                transformer.transform(source, file);
                System.out.println("Создание XML файла закончено");

            } catch (Exception e) {
                e.printStackTrace();


            }
        }
    // метод для создания нового узла XML-файла
    private static Node getLanguage(Document doc, List<String> stringList) {
        Element library = doc.createElement("library");
        String firstElem = null;
        String secondElem = null;
        String secondElemOven = null;
        String secondElempowerConsumption = null;

        // устанавливаем атрибут id
        for (int i=0; i<stringList.size();i++) {

            if (stringList.get(i).contains("ID=")) {
                for (String retval : stringList.get(i).split("=")) {
                    if (retval.contains("ID")) {
                        firstElem = retval;
                    } else {
                        secondElem = retval;

                        library.setAttribute(firstElem, secondElem);
                    }
                }
            }
            if (stringList.get(i).contains("NAMETYPE=")) {
                for (String retval : stringList.get(i).split("=")) {
                    if (retval.contains("NAMETYPE")) {
                        firstElem = retval;
                    } else {
                        secondElem = retval;
                        secondElemOven = retval;
                        library.setAttribute("typeinfo", secondElem);
                    }
                }

            }
        }

        for (int i=0; i<stringList.size();i++) {
            for (SearchCriteria.Oven d : SearchCriteria.Oven.values()) {
                if(stringList.get(i).contains(d.toString().toUpperCase().replace("_","")+"=")){
                    if(secondElemOven.equals("'OVEN'")){
                        for (String retval : stringList.get(i).split("=")) {
                            if(retval.contains(d.toString().toUpperCase().replace("_",""))){
                                firstElem = retval;
                            }
                            else {
                                    secondElempowerConsumption = retval;
                                    library.appendChild(getLanguageElements(doc, library, d.toString(), secondElempowerConsumption));

                            }
                        }
                    }
                }
            }
        }

        for (int i=0; i<stringList.size();i++) {
            for (SearchCriteria.Laptop d : SearchCriteria.Laptop.values()) {
                if(stringList.get(i).contains(d.toString().toUpperCase().replace("_","")+"=")){
                    if(secondElemOven.equals("'LAPTOP'")){
                        for (String retval : stringList.get(i).split("=")) {
                            if(retval.contains(d.toString().toUpperCase().replace("_",""))){
                                firstElem = retval;
                            }
                            else {
                                secondElempowerConsumption = retval;
                                library.appendChild(getLanguageElements(doc, library, d.toString(), secondElempowerConsumption));

                            }
                        }
                    }
                }
            }
        }

        return library;
    }

    private static Node getLanguage(Document doc, String id, String nameType, Criteria criteria) {
        Element library = doc.createElement("library");

        // устанавливаем атрибут id
        String lastAttribute;

         // устанавливаем атрибут id
        library.setAttribute("nameType", nameType.toUpperCase());
        library.setAttribute("ID", id);

        // создаем элемент name

        //    library.appendChild(getLanguageElements(doc, library, entry.getKey(), entry.getValue().toString()));

        for (String key : criteria.keySet()) {
            String value = criteria.get(key);
            library.appendChild(getLanguageElements(doc, library, key, value));
        }


        return library;
    }
    // утилитный метод для создание нового узла XML-файла
    private static Node getLanguageElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
