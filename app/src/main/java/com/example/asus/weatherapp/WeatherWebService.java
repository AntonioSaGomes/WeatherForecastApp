package com.example.asus.weatherapp;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;
import retrofit2.http.Query;

public interface WeatherWebService {

    @GET("daily")
    Call<Weather> getWeather(@Query("id") int id,@Query("appid") String api_key);


}
