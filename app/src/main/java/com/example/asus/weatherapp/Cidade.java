package com.example.asus.weatherapp;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cidade {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("country")
    @Expose
    private String country;

    public Cidade(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
