package com.ragamania.bararaga.view.fragment.articles;

import android.content.Context;
import android.view.ViewGroup;

import com.ragamania.bararaga.R;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;

import timber.log.Timber;

/**
 * Created by wildangarviandi on 10/29/16.
 */

public class ArticlesRecyclerAdapter extends BaseRecyclerAdapter {

    private static int LAYOUT_BIG = 1;
    private static int LAYOUT_SMALL = 2;

    public ArticlesRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return LAYOUT_BIG;
        else return LAYOUT_SMALL;
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        if (viewType == LAYOUT_BIG) return R.layout.list_row_articles_big;
        else return R.layout.list_row_articles_small;
    }

    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == LAYOUT_BIG) return new ArticlesBigHolder(mContext,
                getView(parent, viewType), mItemClickListener, mLongItemClickListener);
        else return new ArticlesHolder(mContext, getView(parent, viewType),
                mItemClickListener, mLongItemClickListener);
    }
}
