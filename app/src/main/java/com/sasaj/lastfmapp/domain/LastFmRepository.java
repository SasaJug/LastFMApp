package com.sasaj.lastfmapp.domain;

import android.util.Log;

import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Image;
import com.sasaj.lastfmapp.domain.entity.Track;
import com.sasaj.lastfmapp.httpclient.HttpClient;
import com.sasaj.lastfmapp.httpclient.RetrofitClient;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sjugurdzija on 1/22/2018
 */

public class LastFmRepository implements Repository {

    private static final String LOG_TAG = LastFmRepository.class.getSimpleName();

    private HttpClient httpClient;
    private LocalStorage localStorage;

    @Inject
    public LastFmRepository( HttpClient httpClient, LocalStorage storage) {
        this.httpClient = httpClient;
        this.localStorage = storage;
    }

    public Flowable<List<Artist>> getArtists() {
        return localStorage.getArtists();
    }

    @Override
    public void refreshArtists() {
        httpClient.getChartArtists(1, RetrofitClient.LIMIT)
                .toFlowable()
                .subscribeOn(Schedulers.io())
                .doOnNext(chart -> {
                    localStorage.insertAllArtists(chart.getArtists().getArtist());
                })
                .subscribe(chart -> Log.e(LOG_TAG, "size " + chart.getArtists().getArtist().size()));
    }

    @Override
    public void refreshTracks() {
        httpClient.getChartTracks(1, RetrofitClient.LIMIT)
                .toFlowable()
                .subscribeOn(Schedulers.io())
                .doOnNext(chart -> {
                    localStorage.insertAllTracks(chart.getTracks().getTrack());
                })
                .subscribe(chart -> Log.e(LOG_TAG, "size " + chart.getTracks().getTrack()));
    }

    public Flowable<Artist> getArtist(String mbid){
         return localStorage.getArtist(mbid);
    }

    public Flowable<List<Image>> getImages(String mbid){
        return localStorage.getImages(mbid);
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
