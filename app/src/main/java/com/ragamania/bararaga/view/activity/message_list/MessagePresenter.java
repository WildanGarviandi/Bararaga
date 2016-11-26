package com.ragamania.bararaga.view.activity.message_list;

import android.content.Context;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.data.remote.APIService;
import com.ragamania.bararaga.model.BaseResponsePlaces;
import com.ragamania.bararaga.model.ChatListModel.BaseReponseChatList;
import com.ragamania.bararaga.view.fragment.places.PlacesMvpView;

import net.derohimat.baseapp.presenter.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by wildan on 23/11/16.
 */

public class MessagePresenter implements BasePresenter<MessageMvpView> {

    @Inject
    APIService mAPIService;

    private MessageMvpView mMessageMvpView;
    private Subscription mSubscription;
    private BaseReponseChatList mResponse;

    @Inject
    public MessagePresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Override
    public void attachView(MessageMvpView view) {
        mMessageMvpView = view;
    }

    @Override
    public void detachView() {
        mMessageMvpView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadMessage() {
        if (mSubscription != null) mSubscription.unsubscribe();

        BaseApplication baseApplication = BaseApplication.get(mMessageMvpView.getContext());

        mSubscription = mAPIService.getListMessage()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(baseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<BaseReponseChatList>() {
                    @Override
                    public void onCompleted() {
                        Timber.i("Message list loaded : %s", mResponse);
                        mMessageMvpView.loadMessage(mResponse.getObject());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseReponseChatList baseReponseChatList) {
                        mResponse = baseReponseChatList;
                    }
                });
    }
}
