package com.ragamania.bararaga.view.activity.main;

import com.ragamania.bararaga.model.weather.WeatherPojo;
import com.ragamania.bararaga.view.MvpView;

public interface MainMvpView extends MvpView {

    void showWeather(WeatherPojo weatherPojo);

    void showProgress();

    void hideProgress();
}