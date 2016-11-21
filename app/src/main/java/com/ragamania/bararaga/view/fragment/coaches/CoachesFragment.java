package com.ragamania.bararaga.view.fragment.coaches;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ragamania.bararaga.R;
import com.ragamania.bararaga.model.CoachesList;
import com.ragamania.bararaga.view.activity.detail_list.DetailListActivity;

import net.derohimat.baseapp.ui.fragment.BaseFragment;
import net.derohimat.baseapp.ui.view.BaseRecyclerView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class CoachesFragment extends BaseFragment implements CoachesMvpView {

    private static final String TAB_POSITION = "tab_position";

    @Bind(R.id.recyclerview)
    BaseRecyclerView mRecyclerView;

    private CoachesPresenter mPresenter;
    private CoachesRecyclerAdapter mAdapter;

    public static CoachesFragment newInstance(int tabPosition) {
        CoachesFragment fragment = new CoachesFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.coaches_fragment;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        setUpAdapter();
        setUpRecyclerView();
        setUpPresenter();
        setHasOptionsMenu(true);
    }

    private void setUpAdapter() {
        mAdapter = new CoachesRecyclerAdapter(mContext);
        mAdapter.setOnItemClickListener((view, position) -> {
            gotoDetail();
        });
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

    private void setUpPresenter() {
        mPresenter = new CoachesPresenter(getActivity());
        mPresenter.attachView(this);
        mPresenter.loadCoachesList();
    }

    @Override
    public void loadCoachesList(List<CoachesList> coachesList) {
        mAdapter.addAll(coachesList);
        mRecyclerView.refreshComplete();
    }

    private void gotoDetail() {
        Intent i = new Intent(getActivity(), DetailListActivity.class);
        startActivity(i);
        getActivity().overridePendingTransition(0,0);
    }
}
