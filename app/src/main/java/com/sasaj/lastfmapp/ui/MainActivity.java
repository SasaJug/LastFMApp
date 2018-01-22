package com.sasaj.lastfmapp.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.ui.adapter.MainPagerAdapter;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener{

    private MainPagerAdapter adapterViewPager;
    private TabLayout tabLayout;
    private ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        vpPager = findViewById(R.id.vpPager);
        adapterViewPager = new MainPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vpPager);
    }


}
