package com.ragamania.bararaga.view.fragment.coaches;

import android.content.Context;
import android.view.ViewGroup;

import com.ragamania.bararaga.R;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;

/**
 * Created by wildangarviandi on 10/27/16.
 */

public class CoachesRecyclerAdapter extends BaseRecyclerAdapter {
    public CoachesRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        return R.layout.list_row_places_fragment;
    }

    @Override
    public CoachesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CoachesHolder(mContext, getView(parent, viewType), mItemClickListener, mLongItemClickListener);
    }
}
