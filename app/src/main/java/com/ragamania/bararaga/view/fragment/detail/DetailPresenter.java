package com.ragamania.bararaga.view.fragment.detail;

import android.content.Context;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.data.remote.APIService;
import com.ragamania.bararaga.model.forecast.Forecast;

import net.derohimat.baseapp.presenter.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

public class DetailPresenter implements BasePresenter<DetailMvpView> {

    private DetailMvpView mDetailMvpView;
    private Subscription mSubscription;
    private Forecast mForecast;

    @Inject
    public DetailPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Inject
    APIService mAPIService;

    @Override
    public void attachView(DetailMvpView view) {
        mDetailMvpView = view;
    }

    @Override
    public void detachView() {
        mDetailMvpView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadForcast(String from_where) {
        String weatherFromWhere = from_where.trim();
        if (weatherFromWhere.isEmpty()) return;

        if (mSubscription != null) mSubscription.unsubscribe();

        BaseApplication baseApplication = BaseApplication.get(mDetailMvpView.getContext());

        mSubscription = mAPIService.getForecastForCity(weatherFromWhere, "metric", 7)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(baseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<Forecast>() {
                    @Override
                    public void onCompleted() {
                        Timber.i("Forcast loaded %s", mForecast);
                        mDetailMvpView.showForecast(mForecast);
                    }

                    @Override
                    public void onError(Throwable error) {
                        Timber.e("Error loading mForecast %s", error);
                    }

                    @Override
                    public void onNext(Forecast forecast) {
                        mForecast = forecast;
                    }
                });
    }
}