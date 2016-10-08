package com.ragamania.bararaga.view.fragment.articles;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ragamania.bararaga.R;

import net.derohimat.baseapp.ui.fragment.BaseFragment;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class ArticlesFragment extends BaseFragment implements ArticlesMvpView {

    private static final String TAB_POSITION = "tab_position";

    public static ArticlesFragment newInstance(int tabPosition) {
        ArticlesFragment fragment = new ArticlesFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.articles_fragment;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {

    }
}
