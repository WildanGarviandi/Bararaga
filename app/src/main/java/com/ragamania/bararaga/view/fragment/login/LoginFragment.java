package com.ragamania.bararaga.view.fragment.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.view.activity.main.MainActivity;

import net.derohimat.baseapp.ui.fragment.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by wildangarviandi on 10/7/16.
 */

public class LoginFragment extends BaseFragment implements LoginMvpView {

    @Bind(R.id.button_signin)
    Button mButtonSignin;

    private static final String ARG_EXAMPLE = "ARG_EXAMPLE";

    public static LoginFragment newInstance() {
        LoginFragment detailFragment = new LoginFragment();
        return detailFragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.login_fragment;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {

    }

    @OnClick(R.id.button_signin)
    public void gotoDetail() {
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);
        getActivity().overridePendingTransition(0,0);
        getActivity().finish();
    }
}
