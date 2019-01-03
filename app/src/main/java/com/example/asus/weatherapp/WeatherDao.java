package com.example.asus.weatherapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;


@Dao
public interface WeatherDao {

    @Insert()
    void save(Weather weather);

    @Query("Select * from weather where city_name= :city_name")
    LiveData<Weather> load(String city_name);

    @Query("Delete from weather where weather_id= :weather_id")
    void delete(int weather_id);

    @Query("SELECT * FROM weather WHERE city_name = :city_name AND lastRefresh > :lastRefreshMax LIMIT 1")
    Weather hasWeather(String city_name, Date lastRefreshMax);

}
