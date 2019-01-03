package com.example.asus.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Temp {

    //"day":262.65,"min":261.41,"max":262.65,"night":261.41,"eve":262.65,"morn":262.65

    @SerializedName("day")
    @Expose
    private Double day_temp;

    @SerializedName("min")
    @Expose
    private Double day_min_temp;

    @SerializedName("max")
    @Expose
    private Double day_max_temp;

    public Temp(Double day_temp, Double day_min_temp, Double day_max_temp, Double night_temp) {
        this.day_temp = day_temp;
        this.day_min_temp = day_min_temp;
        this.day_max_temp = day_max_temp;
        this.night_temp = night_temp;
    }

    @SerializedName("night")
    @Expose

    private Double night_temp;

    public Double getDay_temp() {
        return day_temp;
    }

    public void setDay_temp(Double day_temp) {
        this.day_temp = day_temp;
    }

    public Double getDay_min_temp() {
        return day_min_temp;
    }

    public void setDay_min_temp(Double day_min_temp) {
        this.day_min_temp = day_min_temp;
    }

    public Double getDay_max_temp() {
        return day_max_temp;
    }

    public void setDay_max_temp(Double day_max_temp) {
        this.day_max_temp = day_max_temp;
    }

    public Double getNight_temp() {
        return night_temp;
    }

    public void setNight_temp(Double night_temp) {
        this.night_temp = night_temp;
    }
}
