package com.sasaj.lastfmapp.domain;

import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Image;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sjugurdzija on 3/1/2018.
 */

public interface LocalStorage {

    Flowable<List<Artist>> getArtists();
    Flowable<Artist> getArtist(String mbid);
    Flowable<List<Image>> getImages(String mbid);

    void insertAll(List<Artist> artists);
}
