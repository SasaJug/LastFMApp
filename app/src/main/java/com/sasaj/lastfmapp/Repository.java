package com.sasaj.lastfmapp;

import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Chart;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by sjugurdzija on 1/22/2018.
 */

public interface Repository {

    Flowable<List<Artist>> getArtists();
    void refreshArtists();
}
