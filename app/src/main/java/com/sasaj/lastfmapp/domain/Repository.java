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

    void refreshArtists();
    void refreshTracks();

    Flowable<List<Artist>> getArtists();
    Flowable<Artist> getArtist(long id);

    Flowable<List<Track>> getTracks();
    Flowable<Track> getTrack(long id);
}
