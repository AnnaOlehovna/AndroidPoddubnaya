package com.olehovnagmail.anya.data.homework6.parsing;

import com.olehovnagmail.anya.data.homework6.convertData.ConvertDate;
import com.olehovnagmail.anya.data.homework6.weatherEntity.City;
import com.olehovnagmail.anya.data.homework6.weatherEntity.Root;
import com.olehovnagmail.anya.data.homework6.weatherEntity.Weather;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import io.reactivex.Observable;

/**
 * Parsing data from XML to entity
 */
public class ParseXML implements Parsing {


    private ConvertDate convertDate = new ConvertDate();
    private Observable<Root> observable;


    public Observable<Root> parsingFile(File file) {
        if(file!=null){
        Root root = new Root();
        Document dom;

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            dom = builder.parse(file);

        } catch (Exception e) {
            return null;
        }

        Element rootElement = dom.getDocumentElement();

        NodeList dateNodeList = rootElement.getElementsByTagName("date");

        Node dateNode = dateNodeList.item(0);

        String dateRoot = dateNode.getTextContent();
        Date date = convertDate.convertStringtoDate(dateRoot);
        root.setDate(date);


        NodeList nameList = rootElement.getElementsByTagName("name");
        Node name = nameList.item(0);
        String nameCenter = name.getTextContent();
        root.setName(nameCenter);

        NodeList weatherNodeList = rootElement.getElementsByTagName("weather");
        Node weatherNode = weatherNodeList.item(0);


        NodeList elementsNodeList = weatherNode.getChildNodes();
        List<Weather> weatherList = new ArrayList<>();


        for (int i = 0; i < elementsNodeList.getLength(); i++) {

            Node node = elementsNodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element element = (Element) node;

            String dateElement = element.getElementsByTagName("date").item(0).getTextContent();
            Date currentDate = convertDate.convertStringtoDate(dateElement);
            String description = element.getElementsByTagName("description").item(0).getTextContent();
            int humidity = Integer.parseInt(element.getElementsByTagName("humidity").item(0).getTextContent());
            int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());


            NodeList locationNodeList = element.getElementsByTagName("location");
            Node locationNode = locationNodeList.item(0);
            NodeList elementsLocation = locationNode.getChildNodes();
            HashMap<String, List<City>> locationMap = new HashMap<>();
            for (int j = 0; j < elementsLocation.getLength(); j++) {

                Node node1 = elementsLocation.item(j);
                if (node1.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                String string = node1.getTextContent();
                Pattern pattern = Pattern.compile("^([A-Za-z0-9-]+), ([A-Z]{2})$");
                Matcher matcher = pattern.matcher(string);
                if(matcher.matches()){
                String key = matcher.group(2);
                String cityName = matcher.group(1);
                City city = new City();
                city.setName(cityName);
                if (locationMap.containsKey(key)) {
                    locationMap.get(key).add(city);
                } else {
                    List<City> cityList = new ArrayList<>();
                    cityList.add(city);
                    locationMap.put(key, cityList);
                }
            }
            }
            int tempMax = Integer.parseInt(element.getElementsByTagName("temp_max").item(0).getTextContent());
            int tempMin = Integer.parseInt(element.getElementsByTagName("temp_min").item(0).getTextContent());
            String title = element.getElementsByTagName("title").item(0).getTextContent();

        Weather weather = new Weather(currentDate,description,humidity,id,locationMap,tempMax,tempMin,title);
        weatherList.add(weather);
        }
        root.setWeatherList(weatherList);
        return observable = Observable.just(root);
    }else{
         return null;
        }
    }



}
