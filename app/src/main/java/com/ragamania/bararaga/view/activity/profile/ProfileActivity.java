package com.ragamania.bararaga.view.activity.profile;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.view.AppBaseActivity;

import butterknife.Bind;

/**
 * Created by wildangarviandi on 10/29/16.
 */

public class ProfileActivity extends AppBaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.profile_activity;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }
}
