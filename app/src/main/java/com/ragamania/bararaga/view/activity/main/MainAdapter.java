package com.ragamania.bararaga.view.activity.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ragamania.bararaga.view.fragment.articles.ArticlesFragment;
import com.ragamania.bararaga.view.fragment.coaches.CoachesFragment;
import com.ragamania.bararaga.view.fragment.places.PlacesFragment;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class MainAdapter extends FragmentStatePagerAdapter {

    private static final int NUMBER_OF_TAB = 3;

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PlacesFragment.newInstance(position);
            case 1:
                return CoachesFragment.newInstance(position);
            case 2:
                return ArticlesFragment.newInstance(position);
            default:
                return PlacesFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return NUMBER_OF_TAB;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "PLACES";
            case 1:
                return "COACHES";
            case 2:
                return "ARTICLES";
            default:
                return "";
        }
    }
}
