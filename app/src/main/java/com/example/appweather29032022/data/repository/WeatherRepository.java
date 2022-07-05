package com.example.appweather29032022.data.repository;

import com.example.appweather29032022.common.AppConstant;
import com.example.appweather29032022.data.remote.ApiService;
import com.example.appweather29032022.data.remote.RetrofitClient;
import com.example.appweather29032022.data.remote.model.WeatherSearchResponse;

import io.reactivex.rxjava3.core.Flowable;

/**
 * Created by pphat on 7/5/2022.
 */
public class WeatherRepository {
    private ApiService apiService;

    public WeatherRepository() {
        apiService = RetrofitClient.getInstance().getApiService();
    }

    public Flowable<WeatherSearchResponse> searchCityName(String cityName) {
        return apiService.searchCityName(AppConstant.APP_ID_WEATHER_KEY, "metric", cityName);
    }
}
