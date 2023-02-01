package com.indigobluw.project.apistructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// OB! i Kristoffers presentation ligger inte controller i apistructure mappen

@RestController
public class ConsumerController { //webservice lektion 5

    /*@GetMapping("/helloApi")
    public String sayHelloApi() {
        return "Hello world from API";
    }*/

    @GetMapping("/callWeatherApi")
    public /*former String*/ConsumerModel callWeatherApi() {

        final String url = "https://api.open-meteo.com/v1/forecast?latitude=59.33&longitude=18.07&hourly=temperature_2m,snowfall&timezone=Europe%2FBerlin";//http://localhost:8080/helloApi";
        RestTemplate restTemplate = new RestTemplate();
        ConsumerModel consumerModel;

        /*
        what could go wrong?
        #1 no internet
        -api server down
        -data is null
        */

        try {
            consumerModel = restTemplate.getForObject(url, ConsumerModel.class);
            //kollar att datan faktiskt existerar
            //tar ut endast den data vi är intresserade av ist för att ta ut allt från en API
            if(consumerModel != null) {
                System.out.println(consumerModel.getHourly().getTime().get(0) + " " +
                        consumerModel.getHourly().getSnowfall().get(3));
            }
            return consumerModel;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
            }


    }

}
