package com.sasaj.lastfmapp.domain;

import android.content.Context;
import android.util.Log;

import com.sasaj.lastfmapp.Repository;
import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Chart;
import com.sasaj.lastfmapp.httpclient.RetrofitClient;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sjugurdzija on 1/22/2018.
 */

public class LastFmRepository implements Repository {

    private static final String LOG_TAG = LastFmRepository.class.getSimpleName();
    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static LastFmRepository sInstance;
    private final Context context;

    public LastFmRepository(Context context) {
        this.context = context;
    }

    public synchronized static LastFmRepository getInstance(Context context) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new LastFmRepository(context);
                Log.d(LOG_TAG, "Made new repository");
            }
        }
        return sInstance;
    }

    public Flowable<List<Artist>> getArtists() {
        return DatabaseCreator.getInstance(context).artistDao().getAll();
    }

    @Override
    public void refreshArtists() {
        RetrofitClient.getInstance().getService().listChartArtists(RetrofitClient.API_KEY, 1, RetrofitClient.LIMIT)
                .toFlowable()
                .subscribeOn(Schedulers.io())
                .doOnNext(chart -> DatabaseCreator.getInstance(context).artistDao().insertAll(chart.getArtists().getArtist()))
                .subscribe(chart -> Log.e(LOG_TAG, "size " + chart.getArtists().getArtist().size()));
    }
}
