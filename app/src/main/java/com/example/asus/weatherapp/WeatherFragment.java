package com.example.asus.weatherapp;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.joda.time.DateTime;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;

public class WeatherFragment extends Fragment {


    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private WeatherViewModel viewModel;
    // FOR DESIGN
    @BindView(R.id.weatherCityName) TextView CityName;
    @BindView(R.id.weatherMaxTemp) TextView MaxTemp;
    @BindView(R.id.weatherMinTemp) TextView MinTemp;
    @BindView(R.id.previousDay) Button previousDayButton;
    @BindView(R.id.nextDay) Button nextDayButton;
    @BindView(R.id.weatherImage) ImageView weatherImage;
    @BindView(R.id.weatherDescription) TextView weatherDescription;
    @BindView(R.id.weatherDay) TextView weatherDay;
    @BindView(R.id.newWeather) EditText newWeather;
    @BindView(R.id.newWeatherButton) Button newWeatherButton;

    Date date;
    private int day=0;
    public String city_name = "Lisbon";
    public WeatherFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        previousDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(day - 8 < 0))
                    day-=8;
                configureViewModel();
            }
        });
        nextDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(day + 8> 39))
                    day+=8;
                configureViewModel();
            }
        });
        newWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city_name = newWeather.getText().toString();
                configureViewModel();
            }
        });
        this.configureDagger();
        this.configureViewModel();

    }

    // -----------------
    // CONFIGURATION
    // -----------------

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel(){
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherViewModel.class);
        viewModel.init(city_name);
        viewModel.getWeather().observe(this, weather -> updateUI(weather));
    }

    // -----------------
    // UPDATE UI
    // -----------------

    private void updateUI(@Nullable Weather weather){
        if (weather != null){
            this.CityName.setText(weather.getCity().getName());
            this.MaxTemp.setText(String.valueOf(Math.round(weather.getWeatherList().get(day).getTemp().getDay_max_temp()-272.15)) + "ºC");
            this.MinTemp.setText(String.valueOf(Math.round(weather.getWeatherList().get(day).getTemp().getDay_min_temp()-272.15)) + "ºC");
            this.weatherDescription.setText(weather.getWeatherList().get(day).getTempo().get(0).getMain());
            this.weatherImage.setBackgroundResource(setDrawable(weather.getWeatherList().get(day).getTempo().get(0).getMain()));
            date = DateConverter.toDate(weather.getWeatherList().get(day).getDate()*1000);
            String month = new DateFormatSymbols().getMonths()[new DateTime(date).getMonthOfYear()-1];
            this.weatherDay.setText(new DateTime(date).getDayOfMonth() + " " + month);
        }
        else{
            Toast.makeText(getContext(),"Couldn't find the city specified",Toast.LENGTH_SHORT);
        }
    }

    private int setDrawable(String weatherMain){
        switch (weatherMain){
            case "Clouds":
                return R.drawable.ic_cloudy;
            case "Clear":
                return R.drawable.ic_sunny;
            case "Rain":
                return R.drawable.ic_rainy;
            case "Snow":
                return R.drawable.ic_snow;
        }
        return R.drawable.ic_sunny;
    }
}