package com.example.appweather29032022.presentation.view.acitivty.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.appweather29032022.common.TimeFormat;
import com.example.appweather29032022.data.model.WeatherModel;
import com.example.appweather29032022.data.remote.model.WeatherSearchResponse;
import com.example.appweather29032022.data.repository.WeatherRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by pphat on 7/5/2022.
 */
public class SearchWeatherViewModel extends ViewModel {
    private MutableLiveData<WeatherModel> weather = new MutableLiveData<>();
    private MutableLiveData<String> message = new MutableLiveData<>();
    private WeatherRepository repository = new WeatherRepository();

    public SearchWeatherViewModel() {

    }

    public LiveData<WeatherModel> getWeather() {
        return weather;
    }

    public void searchCityName(String cityName) {
        repository
                .searchCityName(cityName)
                .subscribeOn(Schedulers.io())
                .map(response -> {
                    WeatherModel weatherModel = new WeatherModel();
                    if (response.getWeather() != null && response.getWeather().size() > 0) {
                        weatherModel.setMain(response.getWeather().get(0).getMain());
                        weatherModel.setDescription(response.getWeather().get(0).getDescription());
                        weatherModel.setDescription(response.getWeather().get(0).getIcon());
                    }

                    if (response.getMain() != null) {
                        weatherModel.setTemp(response.getMain().getTemp());
                        weatherModel.setTempMin(response.getMain().getTempMin());
                        weatherModel.setTempMax(response.getMain().getTempMax());
                        weatherModel.setPressure(response.getMain().getPressure());
                        weatherModel.setHumidity(response.getMain().getHumidity());
                    }

                    if (response.getWind() != null) {
                        weatherModel.setWindSpeed(response.getWind().getSpeed());
                    }

                    weatherModel.setTime(TimeFormat.convertMilliSecondToTime(response.getDt() * 1000));
                    weatherModel.setCountry(response.getSys().getCountry());
                    weatherModel.setName(response.getName());
                    return weatherModel;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable()
                .subscribe(weatherModelObserver);
    }

    private Observer<WeatherModel> weatherModelObserver = new Observer<WeatherModel>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onNext(@NonNull WeatherModel weatherModel) {
            weather.setValue(weatherModel);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            message.setValue(e.getMessage());
        }

        @Override
        public void onComplete() {

        }
    };
}
