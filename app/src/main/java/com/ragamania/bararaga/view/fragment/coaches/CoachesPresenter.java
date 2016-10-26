package com.ragamania.bararaga.view.fragment.coaches;

import android.content.Context;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.data.remote.APIService;
import com.ragamania.bararaga.model.BaseResponseCoaches;

import net.derohimat.baseapp.presenter.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class CoachesPresenter implements BasePresenter<CoachesMvpView> {
    private CoachesMvpView mCoachesMvpView;
    private Subscription mSubscription;
    private BaseResponseCoaches mResponse;

    @Inject
    public CoachesPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Inject
    APIService mAPIService;

    @Override
    public void attachView(CoachesMvpView view) {
        mCoachesMvpView = view;
    }

    @Override
    public void detachView() {
        mCoachesMvpView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadCoachesList() {

        if (mSubscription != null) mSubscription.unsubscribe();

        BaseApplication baseApplication = BaseApplication.get(mCoachesMvpView.getContext());

        mSubscription = mAPIService.getCoachesList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(baseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<BaseResponseCoaches>() {
                    @Override
                    public void onCompleted() {
                        Timber.i("Coaches loaded %s", mResponse);
                        mCoachesMvpView.loadCoachesList(mResponse.getArray());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("Error loading mForecast %s", e);
                    }

                    @Override
                    public void onNext(BaseResponseCoaches coachesList) {
                        mResponse = coachesList;
                    }
                });
    }
}
