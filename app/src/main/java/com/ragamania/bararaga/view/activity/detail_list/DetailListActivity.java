package com.ragamania.bararaga.view.activity.detail_list;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ragamania.bararaga.R;
import com.ragamania.bararaga.model.DetailCoaches.Coaches;
import com.ragamania.bararaga.view.AppBaseActivity;

import butterknife.Bind;

/**
 * Created by wildangarviandi on 10/27/16.
 */

public class DetailListActivity extends AppBaseActivity implements DetailListMvpView {

    @Bind(R.id.text_name_coach) TextView textNameCoach;
    @Bind(R.id.text_profession_coach) TextView textProfessionCoach;
    @Bind(R.id.text_overview) TextView textOverview;
    @Bind(R.id.text_schedule) TextView textSchedule;
    @Bind(R.id.img_detail) ImageView ivDetail;
    @Bind(R.id.toolbar) Toolbar mToolbar;

    DetailListPresenter mDetailListPresenter;

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
        return R.layout.detail_list_activity;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        mDetailListPresenter = new DetailListPresenter(this);
        mDetailListPresenter.attachView(this);

        mDetailListPresenter.loadDetailCoach();
    }

    @Override
    public void loadDetailCoach(Coaches coaches) {
        textNameCoach.setText(coaches.getName());
        textProfessionCoach.setText(coaches.getProfession());
        textOverview.setText(coaches.getOverview());
        textSchedule.setText(coaches.getSchedule().get(1).getDay() +
                coaches.getSchedule().get(1).getTime());

        Glide.with(this.mContext)
                .load(coaches.getBio().getImage_url())
                .into(ivDetail);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
