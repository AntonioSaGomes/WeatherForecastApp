package com.example.asus.weatherapp;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class CoordConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public static Coord objectToList(String coord){
        if (coord == null){
            return null;
        }

        Type objectType = new TypeToken<Coord>() {}.getType();

        return gson.fromJson(coord,objectType);
    }

    @TypeConverter
    public static String objectToString(Coord coord){
        return gson.toJson(coord);
    }

}