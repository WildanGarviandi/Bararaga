package com.ragamania.bararaga.view.activity.message_list;

import android.content.Context;
import android.view.View;

import com.ragamania.bararaga.model.ChatListModel.Object;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;

/**
 * Created by wildan on 23/11/16.
 */

public class MessageHolder extends BaseItemViewHolder<Object> {



    public MessageHolder(Context context,
                         View itemView,
                         BaseRecyclerAdapter.OnItemClickListener itemClickListener,
                         BaseRecyclerAdapter.OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
        this.mContext = context;
    }

    @Override
    public void bind(Object object) {

    }
}
