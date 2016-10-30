package com.ragamania.bararaga.view.activity.message;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.view.AppBaseActivity;

import butterknife.Bind;

/**
 * Created by wildangarviandi on 10/31/16.
 */

public class MessageActivity extends AppBaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.text_header_chat)
    TextView mTVHeaderChat;

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
        return R.layout.message_activity;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }
}
