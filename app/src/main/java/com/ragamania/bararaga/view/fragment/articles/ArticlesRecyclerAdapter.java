package com.ragamania.bararaga.view.fragment.articles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;

/**
 * Created by wildangarviandi on 10/29/16.
 */

public class ArticlesRecyclerAdapter extends BaseRecyclerAdapter {

    public ArticlesRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        return 0;
    }

    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
