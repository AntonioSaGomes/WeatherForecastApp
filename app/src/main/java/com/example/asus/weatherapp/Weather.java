package com.example.asus.weatherapp;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

@Entity
public class Weather {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @Expose
    private int weather_id;

    @SerializedName("list")
    @Expose
    @TypeConverters(WeatherListConverter.class)
    private List<WeatherList> weatherList;

    @SerializedName("city")
    @Expose
    @Embedded(prefix = "city_")
    @TypeConverters(CidadeConverter.class)
    private Cidade city;



    private Date lastRefresh;

    @NonNull
    public int getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(@NonNull int weather_id) {
        this.weather_id = weather_id;
    }


    public Weather(@NonNull int weather_id, List<WeatherList> weatherList, Cidade city, Date lastRefresh) {
        this.weather_id = weather_id;
        this.weatherList = weatherList;
        this.city = city;
        this.lastRefresh = lastRefresh;
    }



    public List<WeatherList> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<WeatherList> weatherList) {
        this.weatherList = weatherList;
    }

    public Cidade getCity() {
        return city;
    }

    public void setCity(Cidade city) {
        this.city = city;
    }

    public Date getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }
}