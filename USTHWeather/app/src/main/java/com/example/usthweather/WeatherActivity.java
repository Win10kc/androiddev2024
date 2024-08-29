package com.example.usthweather;

import android.os.Bundle;
//import android.util.Log;
//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class WeatherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Check if the fragment container is available
        if (findViewById(R.id.fragment_container) != null) {
            // Avoid overlapping fragments when activity is recreated
            if (savedInstanceState != null) {
                return;
            }

            // Create a new instance of ForecastFragment
            ForecastFragment forecastFragment = new ForecastFragment();

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, forecastFragment).commit();
        }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.i(TAG, "onStart called");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.i(TAG, "onResume called");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.i(TAG, "onPause called");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.i(TAG, "onStop called");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.i(TAG, "onDestroy called");
    }
}
