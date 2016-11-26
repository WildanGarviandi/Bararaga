package com.ragamania.bararaga.view.activity.message_list;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ragamania.bararaga.R;
import com.ragamania.bararaga.model.ChatListModel.Object;
import com.ragamania.bararaga.view.AppBaseActivity;

import net.derohimat.baseapp.ui.view.BaseRecyclerView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by wildangarviandi on 10/31/16.
 */

public class MessageActivity extends AppBaseActivity implements MessageMvpView {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.text_header_chat) TextView mTVHeaderChat;
    @Bind(R.id.recycler_message) BaseRecyclerView mRecyclerView;

    private MessagePresenter mPresenter;
    private MessageRecyclerAdapter mAdapter;

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
        setupAdapter();
        setupRecyclerView();
        setupPresenter();
    }

    private void setupPresenter() {
        mPresenter = new MessagePresenter(this);
        mPresenter.attachView(this);
        mPresenter.loadMessage();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
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

    private void setupAdapter() {
        mAdapter = new MessageRecyclerAdapter(mContext);
        mAdapter.setOnItemClickListener((view, position) -> {

        });
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loadMessage(List<Object> listMessage) {
        mAdapter.addAll(listMessage);
        mRecyclerView.refreshComplete();
    }
}
