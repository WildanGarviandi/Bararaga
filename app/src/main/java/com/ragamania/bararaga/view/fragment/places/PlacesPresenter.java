package com.ragamania.bararaga.view.fragment.places;

import android.content.Context;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.data.remote.APIService;
import com.ragamania.bararaga.model.PlacesList;

import net.derohimat.baseapp.presenter.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class PlacesPresenter implements BasePresenter<PlacesMvpView> {

    private PlacesMvpView mPlacesMvpView;
    private Subscription mSubscription;
    private PlacesList mPlacesList;
    
    @Inject
    public PlacesPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Inject
    APIService mAPIService;

    @Override
    public void attachView(PlacesMvpView view) {
        mPlacesMvpView = view;
    }

    @Override
    public void detachView() {
        mPlacesMvpView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadPlacesList() {

        if (mSubscription != null) mSubscription.unsubscribe();

        BaseApplication baseApplication = BaseApplication.get(mPlacesMvpView.getContext());

        mSubscription = mAPIService.getPlaceList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(baseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<PlacesList>() {
                    @Override
                    public void onCompleted() {
                        Timber.i("places loaded %s", mPlacesList);
                        mPlacesMvpView.loadPlacesList(mPlacesList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("Error loading mForecast %s", e);
                    }

                    @Override
                    public void onNext(PlacesList placesList) {
                        mPlacesList = placesList;
                    }
                });
    }
}
