package com.example.usthweather;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeatherAndForecastFragment extends Fragment {

    public WeatherAndForecastFragment() {
        //empty constructor
    }

    public static WeatherAndForecastFragment newInstance(String cityName) {
        WeatherAndForecastFragment fragment = new WeatherAndForecastFragment();
        Bundle args = new Bundle();
        args.putString("city_name", cityName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            String cityName = getArguments().getString("city_name");
            // Handle the cityName if needed (pass it to child fragments, etc.)
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);

        // Add WeatherFragment and ForecastFragment
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.weather_container, new WeatherFragment());
        transaction.replace(R.id.forecast_container, new ForecastFragment());
        transaction.commit();

        return view;
    }
}
