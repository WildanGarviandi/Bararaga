package com.ragamania.bararaga.view.fragment.articles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.view.fragment.coaches.CoachesHolder;

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
        return R.layout.list_row_articles_big;
    }

    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticlesHolder(mContext, getView(parent, viewType), mItemClickListener, mLongItemClickListener);
    }
}
