package com.sasaj.lastfmapp.domain;

import android.content.Context;
import android.support.v4.util.Pair;
import android.util.Log;

import com.sasaj.lastfmapp.Repository;
import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.httpclient.RetrofitClient;

import java.util.List;

import io.reactivex.Flowable;
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
                .flatMap(chart -> Flowable.fromIterable(chart.getArtists().getArtist()))
                .doOnNext(artist -> DatabaseCreator.getInstance(context).artistDao().insert(artist))
                .flatMap(artist -> Flowable.fromIterable(artist.getImage()), (artist, image) -> new Pair<>(image, artist))
                .subscribe(pair -> DatabaseCreator.getInstance(context).getOpenHelper().getWritableDatabase()
                        .execSQL("INSERT INTO images(artist_mbid, text, size) VALUES (?, ?, ?)",new String[] {pair.second.getMbid(), pair.first.getText(), pair.first.getSize()}));
    }
}
