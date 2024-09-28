package com.example.usthweather;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    TabLayout tabLayout = findViewById(R.id.tab_layout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up ViewPager and TabLayout
        ViewPager viewPager = findViewById(R.id.viewpager);
        WeatherPagerAdapter adapter = new WeatherPagerAdapter(getSupportFragmentManager());

        // Add fragments for cities
        adapter.addFragment(WeatherAndForecastFragment.newInstance("Hanoi, Vietnam"));
        adapter.addFragment(WeatherAndForecastFragment.newInstance("Paris, France"));
        adapter.addFragment(WeatherAndForecastFragment.newInstance("Toulouse, France"));
        viewPager.setAdapter(adapter);

        // Set up TabLayout
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        // Set titles for each tab
        tabLayout.getTabAt(0).setText(getString(R.string.hanoi_vietnam));
        tabLayout.getTabAt(1).setText(getString(R.string.paris_france));
        tabLayout.getTabAt(2).setText(getString(R.string.toulouse_france));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Use if-else instead of switch
        if (item.getItemId() == R.id.action_refresh) {
            // Show a toast when refresh is clicked
            Toast.makeText(this, "Refreshing", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            // Start PrefActivity when settings is clicked
            Intent intent = new Intent(this, PrefActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
