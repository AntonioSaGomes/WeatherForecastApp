package com.example.asus.weatherapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import javax.inject.Inject;

public class WeatherViewModel extends ViewModel {

    private LiveData<Weather> weather;
    private WeatherRepository weatherRepo;

    @Inject
    public WeatherViewModel(WeatherRepository weatherRepo){
        this.weatherRepo = weatherRepo;
    }

    public void init(String city_name){
        Log.d("ViewModelInit:",city_name);
        weather = weatherRepo.getWeather(city_name);
    }

    public LiveData<Weather> getWeather() { return this.weather; }
}
