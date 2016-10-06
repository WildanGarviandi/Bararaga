package com.ragamania.bararaga.view.activity.auth;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.view.AppBaseActivity;
import com.ragamania.bararaga.view.fragment.login.LoginFragment;

/**
 * Created by wildangarviandi on 10/6/16.
 */

public class AuthActivity extends AppBaseActivity implements AuthMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getBaseFragmentManager()
                .beginTransaction()
                .replace(R.id.container_rellative, LoginFragment.newInstance())
                .addToBackStack(null).commit();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.auth_activity;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }
}
