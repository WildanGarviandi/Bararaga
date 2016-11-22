package com.ragamania.bararaga.view.activity.detail_article;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.view.AppBaseActivity;

import butterknife.Bind;

/**
 * Created by wildangarviandi on 11/8/16.
 */

public class DetailArticleActivity extends AppBaseActivity implements DetailArticleMvpView {

    @Bind(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected int getResourceLayout() {
        return R.layout.detail_activity_layout;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String articleID = getIntent().getStringExtra("ARTICLE_ID");

        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(false);
        }
    }
}
