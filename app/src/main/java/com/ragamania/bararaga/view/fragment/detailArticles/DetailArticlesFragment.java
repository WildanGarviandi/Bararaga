package com.ragamania.bararaga.view.fragment.detailArticles;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ragamania.bararaga.R;

import net.derohimat.baseapp.ui.fragment.BaseFragment;

/**
 * Created by wildangarviandi on 11/8/16.
 */

public class DetailArticlesFragment extends BaseFragment implements DetailArticlesMvpView {

    private static final String ARTICLE_ID = "article_id";


    private DetailArticlesPresenter mPresenter;

    public static DetailArticlesFragment newInstance(String articleID) {
        DetailArticlesFragment detailArticlesFragment = new DetailArticlesFragment();
        Bundle args = new Bundle();
        args.putString(ARTICLE_ID, articleID);
        detailArticlesFragment.setArguments(args);
        return detailArticlesFragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.detail_article_fragment;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
