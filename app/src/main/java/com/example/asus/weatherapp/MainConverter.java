package com.example.asus.weatherapp;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class MainConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public static Main objectToList(String main){
        if (main == null){
            return null;
        }

        Type objectType = new TypeToken<Main>() {}.getType();

        return gson.fromJson(main,objectType);
    }

    @TypeConverter
    public static String objectToString(Main main){
        return gson.toJson(main);
    }

}
