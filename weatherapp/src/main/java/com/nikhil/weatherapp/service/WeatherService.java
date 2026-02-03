package com.nikhil.weatherapp.service;


import com.nikhil.weatherapp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherResponse getWeather(String city) {

        String url = "https://api.weatherapi.com/v1/current.json"
                + "?key=" + apiKey
                + "&q=" + city + ",IN"
                + "&aqi=no";


        RestTemplate restTemplate = new RestTemplate();

        Map response = restTemplate.getForObject(url, Map.class);

        Map location = (Map) response.get("location");
        Map current = (Map) response.get("current");
        Map condition = (Map) current.get("condition");

        WeatherResponse wr = new WeatherResponse();
        wr.setCity((String) location.get("name"));
        wr.setCountry((String) location.get("country"));
        wr.setTemperature((double) current.get("temp_c"));
        wr.setFeelsLike((double) current.get("feelslike_c"));
        wr.setHumidity((int) current.get("humidity"));
        wr.setWindSpeed((double) current.get("wind_kph"));
        wr.setCondition((String) condition.get("text"));

        return wr;
    }
}
