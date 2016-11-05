package com.ragamania.bararaga.view.fragment.articles;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ragamania.bararaga.R;
import com.ragamania.bararaga.model.ArticlesModel.ArticlesList;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;

import butterknife.Bind;
import timber.log.Timber;

/**
 * Created by wildangarviandi on 10/29/16.
 */

public class ArticlesHolder extends BaseItemViewHolder<ArticlesList> {

    @Bind(R.id.image_detail_big) ImageView iv_detail_big;
    @Bind(R.id.text_title) TextView tv_title;
    @Bind(R.id.image_source) ImageView iv_source;
    @Bind(R.id.text_source) TextView tv_source;

    public ArticlesHolder(Context context,
                         View itemView,
                         BaseRecyclerAdapter.OnItemClickListener itemClickListener,
                         BaseRecyclerAdapter.OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
        this.mContext = context;
    }

    @Override
    public void bind(ArticlesList articlesList) {
        Timber.i("Coaches loaded %s", articlesList);
        tv_title.setText(articlesList.getTitle());
        tv_source.setText(articlesList.getSource());

        Glide.with(this.mContext)
                .load(articlesList.getImg_article())
                .into(iv_detail_big);

        Glide.with(this.mContext)
                .load(articlesList.getIcon_source())
                .into(iv_source);
    }
}
