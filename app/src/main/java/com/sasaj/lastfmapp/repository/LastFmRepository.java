package com.sasaj.lastfmapp.repository;

import android.util.Log;

import com.sasaj.lastfmapp.domain.Artist;
import com.sasaj.lastfmapp.domain.Track;
import com.sasaj.lastfmapp.repository.local.database.LocalStorage;
import com.sasaj.lastfmapp.repository.remote.httpclient.HttpClient;
import com.sasaj.lastfmapp.repository.remote.httpclient.RetrofitClient;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sjugurdzija on 1/22/2018
 */

public class LastFmRepository implements Repository {

    private static final String TAG = LastFmRepository.class.getSimpleName();

    private HttpClient httpClient;
    private LocalStorage localStorage;

    @Inject
    public LastFmRepository(HttpClient httpClient, LocalStorage storage) {
        this.httpClient = httpClient;
        this.localStorage = storage;
    }

    @Override
    public Disposable refreshArtists() {
        return httpClient.getChartArtists(1, RetrofitClient.LIMIT)
                .subscribeOn(Schedulers.io())
                .subscribe(chart -> localStorage.insertAllArtists(chart.getArtists().getArtist()),
                        throwable -> Log.e(TAG, "refreshArtists: " + throwable.getMessage()));
    }

    @Override
    public Disposable  refreshTracks() {
        return httpClient.getChartTracks(1, RetrofitClient.LIMIT)
                .subscribeOn(Schedulers.io())
                .subscribe(chart -> localStorage.insertAllTracks(chart.getTracks().getTrack()),
                        throwable -> Log.e(TAG, "refreshTracks: " + throwable.getMessage()));
    }

    @Override
    public Flowable<List<Artist>> getArtists() {
        return localStorage.getArtists();
    }

    @Override
    public Flowable<Artist> getArtist(long id) {
        return localStorage.getArtist(id);
    }

    @Override
    public Flowable<List<Track>> getTracks() {
        return localStorage.getTracks();
    }

    @Override
    public Flowable<Track> getTrack(long id) {
        return localStorage.getTrack(id);
    }


}
