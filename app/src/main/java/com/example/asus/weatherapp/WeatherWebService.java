package com.example.asus.weatherapp;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;
import retrofit2.http.Query;

public interface WeatherWebService {

    @GET("forecast")
    Call<Weather> getWeather(@Query("q") String city_name,@Query("appid") String api_key);


}
