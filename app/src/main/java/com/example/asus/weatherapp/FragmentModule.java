package com.example.asus.weatherapp;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract WeatherFragment contributeWeatherFragment();

}
