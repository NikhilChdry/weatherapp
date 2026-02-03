package com.nikhil.weatherapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {

    private String city;
    private String country;
    private double temperature;
    private double feelsLike;
    private String condition;
    private int humidity;
    private double windSpeed;

}
