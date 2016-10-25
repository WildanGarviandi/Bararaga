package com.ragamania.bararaga.view.fragment.places;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.model.PlacesList;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;

import butterknife.Bind;
import timber.log.Timber;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class PlacesHolder extends BaseItemViewHolder<PlacesList> {

    @Bind(R.id.text_place_name)
    TextView tvPlaceName;

    @Bind(R.id.text_text_place_desc)
    TextView tvDescName;

    public PlacesHolder(Context context,
                        View itemView,
                        BaseRecyclerAdapter.OnItemClickListener itemClickListener,
                        BaseRecyclerAdapter.OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
        this.mContext = context;
    }

    @Override
    public void bind(PlacesList mPlacesList) {
        Timber.i("places loaded %s", mPlacesList);
        tvPlaceName.setText("ahaha");
        tvDescName.setText("ahahaha");
    }
}
