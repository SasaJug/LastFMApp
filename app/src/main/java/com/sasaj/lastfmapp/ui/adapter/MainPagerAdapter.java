package com.sasaj.lastfmapp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sasaj.lastfmapp.ui.FragmentSource;

/**
 * Created by DS on 1/17/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;
    private final FragmentSource fragmentSource;

    public MainPagerAdapter(FragmentManager fm, FragmentSource fragmentSource) {
        super(fm);
        this.fragmentSource = fragmentSource;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragmentSource.getArtistsFragment();
            case 1:
                return fragmentSource.getTracksFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS ;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
