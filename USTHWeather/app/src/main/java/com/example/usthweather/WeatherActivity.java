package com.example.usthweather;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Check if we are recreating a previously destroyed instance
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Add the WeatherFragment (Green Area)
            WeatherFragment weatherFragment = new WeatherFragment();
            fragmentTransaction.add(R.id.weather_fragment_container, weatherFragment);

            // Add the ForecastFragment (List of Forecasts)
            ForecastFragment forecastFragment = new ForecastFragment();
            fragmentTransaction.add(R.id.forecast_fragment_container, forecastFragment);

            // Commit the transaction
            fragmentTransaction.commit();
        }
    }
}
