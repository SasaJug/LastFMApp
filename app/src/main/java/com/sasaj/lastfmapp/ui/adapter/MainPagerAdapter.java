package com.sasaj.lastfmapp.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.ui.fragment.ArtistsFragment;
import com.sasaj.lastfmapp.ui.fragment.TracksFragment;

/**
 * Created by DS on 1/17/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;
    private final Context context;
    private int[] tabTitles = new int[]{R.string.top_artists, R.string.top_tracks};

    public MainPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ArtistsFragment.newInstance();
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
        return context.getString(tabTitles[position]);
    }
}
