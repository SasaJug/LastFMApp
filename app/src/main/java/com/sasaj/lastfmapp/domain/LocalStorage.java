package com.sasaj.lastfmapp.domain;

import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Image;
import com.sasaj.lastfmapp.domain.entity.Track;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sjugurdzija on 3/1/2018.
 */

public interface LocalStorage {

    Flowable<List<Artist>> getArtists();
    Flowable<Artist> getArtist(long id);
    void insertAllArtists(List<Artist> artists);

    Flowable<List<Track>> getTracks();
    Flowable<Track> getTrack(long id);
    void insertAllTracks(List<Track> tracks);
}
