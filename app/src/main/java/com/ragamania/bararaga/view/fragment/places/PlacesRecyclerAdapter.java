package com.ragamania.bararaga.view.fragment.places;

import android.content.Context;
import android.view.ViewGroup;

import com.ragamania.bararaga.R;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class PlacesRecyclerAdapter extends BaseRecyclerAdapter {

    public PlacesRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        return R.layout.list_row_places_fragment;
    }

    @Override
    public PlacesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlacesHolder(mContext, getView(parent, viewType), mItemClickListener, mLongItemClickListener);
    }
}
