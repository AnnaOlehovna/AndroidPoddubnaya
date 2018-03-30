package com.olehovnagmail.anya.homeworks.homework6.parsing;



import com.olehovnagmail.anya.homeworks.homework6.entity.City;
import com.olehovnagmail.anya.homeworks.homework6.entity.Root;
import com.olehovnagmail.anya.homeworks.homework6.entity.Weather;
import com.olehovnagmail.anya.homeworks.homework6.convertDate.ConvertDate;


import org.json.JSONArray;
import org.json.JSONObject;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parsing data from JSON to entity
 */
public class ParseJSON implements Parsing {


   private ConvertDate convertDate = new ConvertDate();



    @Override
    public Root parsingFile(File file) {
        if(file!=null){
            Root root = new Root();
            FileReader fileReader = null;

            try{

                fileReader = new FileReader(file);


                BufferedReader reader = new BufferedReader(fileReader);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    sb.append("\n");
                }
                String result = sb.toString();

                JSONObject rootJson = new JSONObject(result);

                String nameRoot = (String) rootJson.get("name");
                Date dateRoot = convertDate.convertStringtoDate((String)rootJson.get("date"));

                JSONArray weatherListJson = (JSONArray) rootJson.get("weather");

                List<Weather> weatherList = new ArrayList<>();

                for(int i =0; i<weatherListJson.length(); i++) {

                    Object elemets = weatherListJson.get(i);
                    JSONObject weatherJson = (JSONObject) elemets;



                    Object id = weatherJson.get("id");

                    String title = (String) weatherJson.get("title");
                    String description = (String) weatherJson.get("description");
                    Date date = convertDate.convertStringtoDate((String)weatherJson.get("date"));
                    Object tempMin = weatherJson.get("temp_min");
                    Object tempMax = weatherJson.get("temp_max");
                    Object humidity = weatherJson.get("humidity");

                    JSONArray locationListJson = (JSONArray) weatherJson.get("location");

                    HashMap<String, List<City>> locationMap = new HashMap<>();

                    for (int j =0; j<locationListJson.length(); j++) {

                        Object aLocationListJson = locationListJson.get(j);

                        String string = (String) aLocationListJson;
                        Pattern pattern = Pattern.compile("^([A-Za-z0-9-]+), ([A-Z]{2})$");
                        Matcher matcher = pattern.matcher(string);
                        if (matcher.matches()) {
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
                    Weather weather = new Weather();
                    weather.setDate(date);
                    weather.setDescription(description);
                    weather.setHumidity((int)humidity);
                    weather.setId((Integer) id);
                    weather.setLocation(locationMap);
                    weather.setTempMax((Integer)tempMax);
                    weather.setTempMin((Integer)tempMin);
                    weather.setTitle(title);
                    weatherList.add(weather);

                }

                root.setName(nameRoot);
                root.setDate(dateRoot);
                root.setWeatherList(weatherList);

            }catch (Exception e){}finally {
                if(fileReader!=null){
                    try{
                        fileReader.close();
                    }catch (IOException e){}

                }
            }
            return root;
        }
    else{
        return null;
    }
}
}

