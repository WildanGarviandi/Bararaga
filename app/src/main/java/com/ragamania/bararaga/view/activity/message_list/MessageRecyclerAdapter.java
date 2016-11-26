package com.ragamania.bararaga.view.activity.message_list;

import android.content.Context;
import android.view.ViewGroup;

import com.ragamania.bararaga.R;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;

/**
 * Created by wildan on 23/11/16.
 */

public class MessageRecyclerAdapter extends BaseRecyclerAdapter {

    public MessageRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        return R.layout.list_row_message;
    }

    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageHolder(mContext, getView(parent, viewType), mItemClickListener, mLongItemClickListener);
    }
}
