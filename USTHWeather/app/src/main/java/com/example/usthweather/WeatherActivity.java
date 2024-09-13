package com.example.usthweather;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // ViewPager setup
        ViewPager viewPager = findViewById(R.id.viewpager);
        WeatherPagerAdapter adapter = new WeatherPagerAdapter(getSupportFragmentManager());

        // Adding instances of WeatherAndForecastFragment for different cities
        adapter.addFragment(WeatherAndForecastFragment.newInstance("Hanoi, Vietnam"));
        adapter.addFragment(WeatherAndForecastFragment.newInstance("Paris, France"));
        adapter.addFragment(WeatherAndForecastFragment.newInstance("Toulouse, France"));

        viewPager.setAdapter(adapter);
    }
}
