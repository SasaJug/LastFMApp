package com.sasaj.lastfmapp.domain;

import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Chart;
import com.sasaj.lastfmapp.domain.entity.Image;
import com.sasaj.lastfmapp.domain.entity.Track;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by sjugurdzija on 1/22/2018.
 */

public interface Repository {

    Flowable<List<Artist>> getArtists();
    void refreshArtists();
    void refreshTracks();

    Flowable<Artist> getArtist(String mbid);
    Flowable<List<Image>> getImages(String mbid);

    Flowable<List<Track>> getTracks();
    Flowable<Track> getTrack(long id);
}
