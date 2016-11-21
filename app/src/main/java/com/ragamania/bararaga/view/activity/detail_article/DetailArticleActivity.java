package com.ragamania.bararaga.view.activity.detail_article;

import android.content.Context;
import android.os.Bundle;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.view.AppBaseActivity;
import com.ragamania.bararaga.view.fragment.detailArticles.DetailArticlesFragment;

/**
 * Created by wildangarviandi on 11/8/16.
 */

public class DetailArticleActivity extends AppBaseActivity implements DetailArticleMvpView {

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
        getBaseFragmentManager()
                .beginTransaction()
                .replace(R.id.content_view, DetailArticlesFragment.newInstance(articleID))
                .addToBackStack(null).commit();
    }
}
