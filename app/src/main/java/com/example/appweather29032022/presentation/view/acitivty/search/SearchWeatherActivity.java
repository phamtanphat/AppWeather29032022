package com.example.appweather29032022.presentation.view.acitivty.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.appweather29032022.R;
import com.example.appweather29032022.data.model.WeatherModel;

public class SearchWeatherActivity extends AppCompatActivity {

    SearchWeatherViewModel weatherViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_weather);

        weatherViewModel = new ViewModelProvider(this).get(SearchWeatherViewModel.class);

        weatherViewModel.getWeather().observe(this, new Observer<WeatherModel>() {
            @Override
            public void onChanged(WeatherModel weatherModel) {
                Log.d("BBB", weatherModel.toString());
            }
        });

        weatherViewModel.getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("BBB", s);
            }
        });

        weatherViewModel.searchCityName("Hanoi213213213");
    }
}
