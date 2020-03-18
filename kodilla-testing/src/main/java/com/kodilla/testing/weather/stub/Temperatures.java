package com.kodilla.testing.weather.stub;

import java.util.HashMap;

public interface Temperatures {
    //1-st el. is a identifier of weather station, 2-nd a temperature in Cel. degrees
    HashMap<Integer,Double> getTemperatures();
}
