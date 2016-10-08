package com.ragamania.bararaga.view.activity.main;

import android.content.Context;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.data.remote.APIService;

import net.derohimat.baseapp.presenter.BasePresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscription;

public class MainPresenter implements BasePresenter<MainMvpView> {

    @Inject
    public MainPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Inject
    APIService mAPIService;
    @Inject
    EventBus mEventBus;

    private MainMvpView mMainMvpView;
    private Subscription mSubscription;

    @Override
    public void attachView(MainMvpView view) {
        mMainMvpView = view;
    }

    @Override
    public void detachView() {
        mMainMvpView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    private static boolean isHttp404(Throwable error) {
        return error instanceof HttpException && ((HttpException) error).code() == 404;
    }
}