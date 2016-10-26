package com.ragamania.bararaga.view.fragment.coaches;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ragamania.bararaga.R;
import com.ragamania.bararaga.model.CoachesList;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;

import butterknife.Bind;
import timber.log.Timber;

/**
 * Created by wildangarviandi on 10/27/16.
 */

public class CoachesHolder extends BaseItemViewHolder<CoachesList> {
    @Bind(R.id.text_place_name)
    TextView tvPlaceName;

    @Bind(R.id.text_text_place_desc)
    TextView tvDescName;

    @Bind(R.id.thumbnail)
    ImageView ivThumbnail;

    public CoachesHolder(Context context,
                        View itemView,
                        BaseRecyclerAdapter.OnItemClickListener itemClickListener,
                        BaseRecyclerAdapter.OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
        this.mContext = context;
    }

    @Override
    public void bind(CoachesList mPlacesList) {
        Timber.i("Coaches loaded %s", mPlacesList);
        tvPlaceName.setText(mPlacesList.getName());
        tvDescName.setText(mPlacesList.getDesc());

        Glide.with(this.mContext)
                .load(mPlacesList.getImg_url())
                .into(ivThumbnail);
    }
}
