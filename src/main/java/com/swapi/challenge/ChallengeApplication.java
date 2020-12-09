package com.swapi.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

@SpringBootApplication
public class ChallengeApplication {

    public static void main(String[] args) throws ParseException {
        //to verify correct keystore
        //System.out.println(System.getProperty("javax.net.ssl.trustStore"));
        //System.out.println(System.getProperty("javax.net.ssl.keyStore"));
        //System.out.println(System.getProperty("java.runtime.version"));
        //System.out.println(System.getProperty("java.home"));

        SpringApplication.run(ChallengeApplication.class, args);
        String url="https://swapi.dev/api/starships/";
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        //System.out.println(resp); //test response

        /*//JsonParser springParser = JsonParserFactory.getJsonParser();
        //Not currently working, stock parser.  Need to review
        List<Object> list = springParser.parseList(resp);
        System.out.println(list);
        for(Object o : list) {    //JSON parser.
            if (o instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) o;
                System.out.println("Items found: " + map.size());

                int i = 0;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                    i++;
                }

            }
            }
            */
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(resp);

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        Object results = jo.get("results");
        JSONArray shipsJSONArray = (JSONArray)results;
        Starship[] shipDataBase = new Starship[shipsJSONArray.size()-1];
        for (int i = 0; i < shipsJSONArray.size()-1; i++)
        {
            Object shipIteratorObj=shipsJSONArray.get(i);
            JSONObject shipIteratorJSON=(JSONObject)shipIteratorObj;
            shipDataBase[i] = new Starship(shipIteratorJSON.get("cargo_capacity").toString(),
                    shipIteratorJSON.get("consumables").toString(),
                    shipIteratorJSON.get("cost_in_credits").toString(),
                    shipIteratorJSON.get("created").toString(),
                    shipIteratorJSON.get("crew").toString(),
                    shipIteratorJSON.get("edited").toString(),
                    shipIteratorJSON.get("hyperdrive_rating").toString(),
                    shipIteratorJSON.get("length").toString(),
                    shipIteratorJSON.get("manufacturer").toString(),
                    shipIteratorJSON.get("max_atmosphering_speed").toString(),
                    shipIteratorJSON.get("MGLT").toString(),
                    shipIteratorJSON.get("model").toString(),
                    shipIteratorJSON.get("name").toString(),
                    shipIteratorJSON.get("passengers").toString(),
                    new String[]{"1", "2"},
                    new String[]{"1", "2"},  // Not Interested in Converting this JSONArray into String Array right now.. too many nests
                    shipIteratorJSON.get("url").toString(),
                    shipIteratorJSON.get("starship_class").toString()
                    );
           /* shipDataBase[i].setCargo_capacity(shipIteratorJSON.get("cargo_capacity").toString());
            shipDataBase[i].setConsumables(shipIteratorJSON.get("consumables").toString());
            shipDataBase[i].setCost_in_credits(shipIteratorJSON.get("cost_in_credits").toString());
            shipDataBase[i].setCreated(shipIteratorJSON.get("created").toString());
            shipDataBase[i].setCrew( shipIteratorJSON.get("crew").toString());
            shipDataBase[i].setEdited(shipIteratorJSON.get("edited").toString());
            shipDataBase[i].setHyperdrive_rating(shipIteratorJSON.get("hyperdrive_rating").toString());
            shipDataBase[i].setLength(shipIteratorJSON.get("length").toString());
            shipDataBase[i].setManufacturer(shipIteratorJSON.get("manufacturer").toString());
            shipDataBase[i].setMax_atmosphering_speed(shipIteratorJSON.get("max_atmosphering_speed").toString());
            shipDataBase[i].setMGLT(shipIteratorJSON.get("MGLT").toString());
            shipDataBase[i].setModel(shipIteratorJSON.get("model").toString());
            shipDataBase[i].setName(shipIteratorJSON.get("name").toString());
            shipDataBase[i].setPassengers(shipIteratorJSON.get("passengers").toString());
            //shipDataBase[i].setPilots(shipIteratorJSON.get("pilots")); Need to convert JSONArray to String Array
            //shipDataBase[i].setFilms((String[])shipIteratorJSON.get("films")); Need to convert JSONArray to String Array
            shipDataBase[i].setUrl(shipIteratorJSON.get("url").toString());
            shipDataBase[i].setVehicle_class(shipIteratorJSON.get("starship_class").toString());

            */
            System.out.println(shipDataBase[i].getName());
            System.out.println(shipDataBase[i].toString());
        }


    }

}

