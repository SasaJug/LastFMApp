package com.sasaj.lastfmapp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.ui.fragment.SingleArtistFragment;
import com.sasaj.lastfmapp.ui.fragment.SingleTrackFragment;
import com.sasaj.lastfmapp.ui.interfaces.OnSingleFragmentInteractionListener;

public class SingleItemActivity extends AppCompatActivity implements OnSingleFragmentInteractionListener{

    public static final String TYPE = "type";
    public static final String MBID = "mbid";
    public static final int ARTIST = 1;
    public static final int TRACK = 2;
    public static final String ARTIST_FRAGMENT_TAG = "artist_fragment";
    public static final String TRACK_FRAGMENT_TAG = "track_fragment";

    public static Intent intentFactory(Context context, int type, String mbid) {
        Intent intent = new Intent(context, SingleItemActivity.class);
        intent.putExtra(TYPE, type);
        intent.putExtra(MBID, mbid);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        setView(getIntent());
    }

    private void setView(Intent intent) {
        String mbid = intent.getStringExtra(MBID);
        FragmentManager fm = getSupportFragmentManager();
        if (mbid != null) {
            switch (intent.getIntExtra(TYPE, -1)) {
                case ARTIST:
                    SingleArtistFragment artist_fragment = SingleArtistFragment.newInstance(mbid);
                    FragmentTransaction ft1 = fm.beginTransaction();
                    ft1.replace(R.id.container, artist_fragment, ARTIST_FRAGMENT_TAG);
                    ft1.commitAllowingStateLoss();
                    break;
                case TRACK:
                    SingleTrackFragment trackFragment = SingleTrackFragment.newInstance(mbid);
                    FragmentTransaction ft2 = fm.beginTransaction();
                    ft2.replace(R.id.container, trackFragment, TRACK_FRAGMENT_TAG);
                    ft2.commitAllowingStateLoss();
                    break;
                default:
                    throw new RuntimeException("type is missing");
            }
        } else {
            throw new RuntimeException("mbid is missing");
        }
    }
}
