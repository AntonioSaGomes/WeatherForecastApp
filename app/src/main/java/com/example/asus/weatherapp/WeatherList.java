package com.example.asus.weatherapp;

import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherList {

    @SerializedName("temp")
    @Expose
    private Temp temp;

    @SerializedName("weather")
    @Expose
    @TypeConverters(TempoConverter.class)
    private List<Tempo> tempo;

    public WeatherList(Temp temp, List<Tempo> tempo) {
        this.temp = temp;
        this.tempo = tempo;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public List<Tempo> getTempo() {
        return tempo;
    }

    public void setTempo(List<Tempo> tempo) {
        this.tempo = tempo;
    }
}
