package com.ragamania.bararaga.view.fragment.detail;

import com.ragamania.bararaga.model.forecast.Forecast;
import com.ragamania.bararaga.view.MvpView;

public interface DetailMvpView extends MvpView {

    void showForecast(Forecast forecast);

}