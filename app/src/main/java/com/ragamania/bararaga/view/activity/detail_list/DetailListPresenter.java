package com.ragamania.bararaga.view.activity.detail_list;

import android.content.Context;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.data.remote.APIService;
import com.ragamania.bararaga.model.DetailCoaches.BaseResponseDetailCoach;

import net.derohimat.baseapp.presenter.BasePresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by wildangarviandi on 10/28/16.
 */

public class DetailListPresenter implements BasePresenter<DetailListMvpView> {

    @Inject
    public DetailListPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Inject
    APIService mAPIService;
    @Inject
    EventBus mEventBus;

    private DetailListMvpView mDetailListMvpView;
    private Subscription mSubscription;
    private BaseResponseDetailCoach mBaseResponseDetailCoach;

    @Override
    public void attachView(DetailListMvpView view) {
        mDetailListMvpView = view;
    }

    @Override
    public void detachView() {
        mDetailListMvpView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadDetailCoach() {

        if (mSubscription != null) mSubscription.unsubscribe();

        BaseApplication baseApplication = BaseApplication.get(mDetailListMvpView.getContext());

        mSubscription = mAPIService.getDetailCoach()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(baseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<BaseResponseDetailCoach>() {
                    @Override
                    public void onCompleted() {
                        Timber.i("Detail Coach loaded %s", mDetailListMvpView);
                        mDetailListMvpView.loadDetailCoach(mBaseResponseDetailCoach.getCoaches());
                    }

                    @Override
                    public void onError(Throwable error) {
                        Timber.e("Error loading Detail Coach %s", error);
                    }

                    @Override
                    public void onNext(BaseResponseDetailCoach baseResponseDetailCoach) {
                        mBaseResponseDetailCoach = baseResponseDetailCoach;
                    }
                });
    }
}
