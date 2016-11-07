package com.ragamania.bararaga.view.fragment.articles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ragamania.bararaga.R;
import com.ragamania.bararaga.model.ArticlesModel.ArticlesList;

import net.derohimat.baseapp.ui.fragment.BaseFragment;
import net.derohimat.baseapp.ui.view.BaseRecyclerView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class ArticlesFragment extends BaseFragment implements ArticlesMvpView {

    @Bind(R.id.recyclerview) BaseRecyclerView mRecyclerView;

    private ArticlesPresenter mPresenter;
    private ArticlesRecyclerAdapter mAdapter;
    private List<ArticlesList> articles;

    private static final String TAB_POSITION = "tab_position";

    public static ArticlesFragment newInstance(int tabPosition) {
        ArticlesFragment fragment = new ArticlesFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.articles_fragment;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        setUpAdapter();
        setUpRecyclerView();
        setUpPresenter();
        setHasOptionsMenu(true);
    }

    private void setUpPresenter() {
        mPresenter = new ArticlesPresenter(getActivity());
        mPresenter.attachView(this);
        mPresenter.loadArticlesList();
    }

    private void setUpRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setPullRefreshEnabled(true);
        mRecyclerView.setLoadingMoreEnabled(false);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    private void setUpAdapter() {
        mAdapter = new ArticlesRecyclerAdapter(mContext);
        mAdapter.setOnItemClickListener((view, position) -> {
            gotoDetailArticles(articles.get(position));
        });
    }

    private void gotoDetailArticles(ArticlesList articlesList) {

    }

    @Override
    public void loadArticles(List<ArticlesList> articlesLists) {
        articles = articlesLists;
        mAdapter.addAll(articlesLists);
        mRecyclerView.refreshComplete();
    }
}
