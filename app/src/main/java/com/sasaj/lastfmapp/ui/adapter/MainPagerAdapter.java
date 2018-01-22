package com.sasaj.lastfmapp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sasaj.lastfmapp.ui.ArtistsFragment;
import com.sasaj.lastfmapp.ui.TracksFragment;

/**
 * Created by DS on 1/17/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ArtistsFragment.newInstance(null, null);
            case 1:
                return TracksFragment.newInstance(null, null);
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
