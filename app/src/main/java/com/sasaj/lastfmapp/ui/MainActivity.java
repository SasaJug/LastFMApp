package com.sasaj.lastfmapp.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.httpclient.RetrofitClient;
import com.sasaj.lastfmapp.ui.adapter.MainPagerAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener, FragmentSource {

    private MainPagerAdapter adapterViewPager;
    private TabLayout tabLayout;
    private ArtistsFragment artistsFragment;
    private TracksFragment tracksFragment;
    private ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        artistsFragment = ArtistsFragment.newInstance(null, null);
        tracksFragment = TracksFragment.newInstance(null, null);

        vpPager = findViewById(R.id.vpPager);
        adapterViewPager = new MainPagerAdapter(getSupportFragmentManager(), this);
        vpPager.setAdapter(adapterViewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vpPager);
    }

    @Override
    public ArtistsFragment getArtistsFragment() {
        return artistsFragment;
    }

    @Override
    public TracksFragment getTracksFragment() {
        return tracksFragment;
    }

    @Override
    public void getArtists() {
        RetrofitClient.getInstance().getService().listChartArtists(RetrofitClient.API_KEY, 1, RetrofitClient.LIMIT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(chart -> artistsFragment.setArtistsList(chart.getArtists().getArtist()));
    }

    @Override
    public void getTracks() {

    }
}
