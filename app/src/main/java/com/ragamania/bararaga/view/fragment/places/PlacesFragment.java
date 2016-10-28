package com.ragamania.bararaga.view.fragment.places;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ragamania.bararaga.R;
import com.ragamania.bararaga.model.PlacesList;
import com.ragamania.bararaga.view.activity.detail_list.DetailListActivity;

import net.derohimat.baseapp.ui.fragment.BaseFragment;
import net.derohimat.baseapp.ui.view.BaseRecyclerView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class PlacesFragment extends BaseFragment implements PlacesMvpView {

    private static final String TAB_POSITION = "tab_position";

    @Bind(R.id.recyclerview)
    BaseRecyclerView mRecyclerView;

    private PlacesPresenter mPresenter;
    private PlacesRecyclerAdapter mAdapter;

    public static PlacesFragment newInstance(int tabPosition) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.places_fragment;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        setUpAdapter();
        setUpRecyclerView();
        setUpPresenter();
        setHasOptionsMenu(true);
    }

    private void setUpAdapter() {
        mAdapter = new PlacesRecyclerAdapter(mContext);
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
        mPresenter = new PlacesPresenter(getActivity());
        mPresenter.attachView(this);
        mPresenter.loadPlacesList();
    }

    @Override
    public void loadPlacesList(List<PlacesList> placesList) {
        mAdapter.addAll(placesList);
        mRecyclerView.refreshComplete();
    }

    private void gotoDetail() {
        Intent i = new Intent(getActivity(), DetailListActivity.class);
        startActivity(i);
        getActivity().overridePendingTransition(0,0);
    }
}
