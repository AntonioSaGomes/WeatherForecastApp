package com.example.asus.weatherapp;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class WeatherRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 3;

    private final WeatherWebService webService;
    private final WeatherDao weatherDao;
    private final Executor executor;

    @Inject
    public WeatherRepository(WeatherWebService webService, WeatherDao weatherDao, Executor executor) {
        this.webService = webService;
        this.weatherDao = weatherDao;
        this.executor = executor;
    }

    public LiveData<Weather> getWeather(String city_name) {
        Log.d("RepoGetWeather:",city_name);
        refreshWeather(city_name);
        return weatherDao.load();
    }

    private void refreshWeather(final String city_name) {
        executor.execute(() -> {
          //  boolean weatherExists = (weatherDao.hasWeather(city_name, getMaxRefreshTime(new Date())) != null);
          //  if (!weatherExists) {
                webService.getWeather(524901,"b1b15e88fa797225412429c1c50c122a1").enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        Log.d("Got_it:",response.body().toString());
                        Toast.makeText(App.context, "Data refreshed from network !", Toast.LENGTH_LONG).show();
                        executor.execute(() -> {
                            Weather weather = response.body();
                            weather.setLastRefresh(new Date());
                            weatherDao.save(weather);
                        });
                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        Log.d("ErrorWeather:",t.getMessage());
                        }
                });
        });
    }

    private Date getMaxRefreshTime(Date currentDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES);
        return cal.getTime();
    }
}
