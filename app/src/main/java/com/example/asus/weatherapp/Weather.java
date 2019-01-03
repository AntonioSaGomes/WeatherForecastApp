package com.example.asus.weatherapp;

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

    @SerializedName("name")
    @Expose
    private String city_name;

    @SerializedName("weather")
    @Expose
    @TypeConverters(TempoConverter.class)
    private List<Tempo> tempo;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("min_temp")
    @Expose
    private Double min_temp;

    @SerializedName("max_temp")
    @Expose
    private Double max_temp;

    @SerializedName("coord")
    @Expose
    @TypeConverters(CoordConverter.class)
    private Coord coord;

    @SerializedName("main")
    @Expose
    @TypeConverters(MainConverter.class)
    private Main main;

    public Weather(@NonNull int weather_id, String city_name, List<Tempo> tempo, String description, Double min_temp, Double max_temp, Coord coord, Main main, Date lastRefresh) {
        this.weather_id = weather_id;
        this.city_name = city_name;
        this.tempo = tempo;
        this.description = description;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.coord = coord;
        this.main = main;
        this.lastRefresh = lastRefresh;
    }

    public List<Tempo> getTempo() {
        return tempo;
    }

    public void setTempo(List<Tempo> tempo) {
        this.tempo = tempo;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    private Date lastRefresh;

    @NonNull
    public int getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(@NonNull int weather_id) {
        this.weather_id = weather_id;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(Double min_temp) {
        this.min_temp = min_temp;
    }

    public Double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(Double max_temp) {
        this.max_temp = max_temp;
    }

    public Date getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }
}