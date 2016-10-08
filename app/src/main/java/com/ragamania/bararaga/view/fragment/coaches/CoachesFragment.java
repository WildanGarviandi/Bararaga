package com.ragamania.bararaga.view.fragment.coaches;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ragamania.bararaga.R;

import net.derohimat.baseapp.ui.fragment.BaseFragment;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class CoachesFragment extends BaseFragment implements CoachesMvpView {

    private static final String TAB_POSITION = "tab_position";

    public static CoachesFragment newInstance(int tabPosition) {
        CoachesFragment fragment = new CoachesFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.coaches_fragment;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {

    }
}
