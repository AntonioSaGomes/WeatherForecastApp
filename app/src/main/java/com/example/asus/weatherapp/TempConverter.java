package com.example.asus.weatherapp;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class TempConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public static Temp objectToList(String temp){
        if (temp == null){
            return null;
        }

        Type objectType = new TypeToken<Temp>() {}.getType();

        return gson.fromJson(temp,objectType);
    }

    @TypeConverter
    public static String objectToString(Temp temp){
        return gson.toJson(temp);
    }

}
