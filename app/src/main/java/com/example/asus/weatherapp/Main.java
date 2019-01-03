package com.example.asus.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    @Expose
    private Double temp;

    @SerializedName("pressure")
    @Expose
    private Double presure;

    @SerializedName("humidity")
    @Expose
    private Double humidity;

    @SerializedName("temp_min")
    @Expose
    private Double temp_min;


    @SerializedName("temp_max")
    @Expose
    private Double temp_max;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getPresure() {
        return presure;
    }

    public void setPresure(Double presure) {
        this.presure = presure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public Main(Double temp, Double presure, Double humidity, Double temp_min, Double temp_max) {
        this.temp = temp;
        this.presure = presure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }
}
