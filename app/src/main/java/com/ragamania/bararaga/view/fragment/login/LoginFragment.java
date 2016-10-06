package com.ragamania.bararaga.view.fragment.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ragamania.bararaga.R;

import net.derohimat.baseapp.ui.fragment.BaseFragment;

/**
 * Created by wildangarviandi on 10/7/16.
 */

public class LoginFragment extends BaseFragment implements LoginMvpView {

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
}
