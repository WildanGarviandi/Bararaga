package com.ragamania.bararaga.view.activity.message_list;

import android.content.Context;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.data.remote.APIService;

import net.derohimat.baseapp.presenter.BasePresenter;

import javax.inject.Inject;

/**
 * Created by wildan on 23/11/16.
 */

public class MessagePresenter implements BasePresenter<MessageMvpView> {

    @Inject
    APIService mAPIService;

    @Inject
    public MessagePresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Override
    public void attachView(MessageMvpView view) {

    }

    @Override
    public void detachView() {

    }
}
