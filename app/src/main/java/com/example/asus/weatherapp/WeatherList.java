package com.example.asus.weatherapp;

import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class WeatherList {

    @SerializedName("main")
    @Expose
    private Temp temp;

    @SerializedName("dt")
    @Expose
    private Long date;

    @SerializedName("weather")
    @Expose
    @TypeConverters(TempoConverter.class)
    private List<Tempo> tempo;

    public WeatherList(Temp temp, Long date, List<Tempo> tempo) {
        this.temp = temp;
        this.date = date;
        this.tempo = tempo;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public List<Tempo> getTempo() {
        return tempo;
    }

    public void setTempo(List<Tempo> tempo) {
        this.tempo = tempo;
    }
}
