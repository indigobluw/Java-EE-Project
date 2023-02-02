package com.indigobluw.project.apiStructure;

import java.util.ArrayList;

public class Hourly {
public ArrayList<String> time;

public ArrayList<Double> temperature_2m;

public ArrayList<Double> snowfall;

    public ArrayList<String> getTime() {
        return time;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }

    public ArrayList<Double> getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(ArrayList<Double> temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public ArrayList<Double> getSnowfall() {
        return snowfall;
    }

    public void setSnowfall(ArrayList<Double> snowfall) {
        this.snowfall = snowfall;
    }

    //toString är viktig vid debugging
    @Override
    public String toString() {
        return "Hourly{" +
                "time=" + time +
                ", temperature_2m=" + temperature_2m +
                ", snowfall=" + snowfall +
                '}';
    }
}
