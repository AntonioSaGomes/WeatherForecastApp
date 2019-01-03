package com.example.asus.weatherapp;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class WeatherListConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public static List<WeatherList> objectToList(String weatherList){
        if (weatherList == null){
            return null;
        }

        Type objectType = new TypeToken<List<WeatherList>>() {}.getType();

        return gson.fromJson(weatherList,objectType);
    }

    @TypeConverter
    public static String objectToString(List<WeatherList> weatherList){
        return gson.toJson(weatherList);
    }
}
