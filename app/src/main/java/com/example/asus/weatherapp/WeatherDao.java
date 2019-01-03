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

    @Query("Select * from weather")
    LiveData<Weather> load();

    @Query("Delete from weather where weather_id= :weather_id")
    void delete(int weather_id);


}
