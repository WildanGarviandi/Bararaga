package com.ragamania.bararaga.view.fragment.places;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.ragamania.bararaga.R;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class PlacesHolder extends BaseItemViewHolder<List> {

    @Bind(R.id.list_item)
    TextView listRow;

    public PlacesHolder(Context context, View itemView, BaseRecyclerAdapter.OnItemClickListener itemClickListener, BaseRecyclerAdapter.OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
        this.mContext = context;
    }

    @Override
    public void bind(List list) {
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            items.add("Tab #" + " item #" + i);
        }

        listRow.setText("hahaha");
    }
}
