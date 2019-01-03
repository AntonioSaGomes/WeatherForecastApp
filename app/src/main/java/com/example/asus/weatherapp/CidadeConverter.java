package com.example.asus.weatherapp;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class CidadeConverter {

    static Gson gson = new Gson();

    @TypeConverter
    public static Cidade objectToList(String cidade){
        if (cidade == null){
            return null;
        }

        Type objectType = new TypeToken<Cidade>() {}.getType();

        return gson.fromJson(cidade,objectType);
    }

    @TypeConverter
    public static String objectToString(Cidade cidade){
        return gson.toJson(cidade);
    }

}
