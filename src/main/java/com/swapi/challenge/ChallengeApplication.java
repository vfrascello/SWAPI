package com.swapi.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import java.util.*;

@SpringBootApplication
public class ChallengeApplication {

    public static void main(String[] args) {
        //to verify correct keystore
        //System.out.println(System.getProperty("javax.net.ssl.trustStore"));
        //System.out.println(System.getProperty("javax.net.ssl.keyStore"));
        //System.out.println(System.getProperty("java.runtime.version"));
        //System.out.println(System.getProperty("java.home"));

        SpringApplication.run(ChallengeApplication.class, args);
        String url="https://swapi.dev/api/starships/";
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        System.out.println(resp); //test response

        JsonParser springParser = JsonParserFactory.getJsonParser();
        //Not currently working, stock parser.  Need to review
        List<Object> list = springParser.parseList(resp);

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
    }

}

