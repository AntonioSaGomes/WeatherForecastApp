package com.example.asus.weatherapp;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TempoConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public static List<Tempo> objectToList(String tempo){
        if (tempo == null){
            return null;
        }

        Type objectType = new TypeToken<List<Tempo>>() {}.getType();

        return gson.fromJson(tempo,objectType);
    }

    @TypeConverter
    public static String objectToString(List<Tempo> tempo){
        return gson.toJson(tempo);
    }

}
