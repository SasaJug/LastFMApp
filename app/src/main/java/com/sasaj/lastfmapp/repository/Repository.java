package com.sasaj.lastfmapp.repository;

import com.sasaj.lastfmapp.domain.Artist;
import com.sasaj.lastfmapp.domain.Track;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * Created by sjugurdzija on 1/22/2018.
 */

public interface Repository {

    Disposable refreshArtists();
    Disposable refreshTracks();

    Flowable<List<Artist>> getArtists();
    Flowable<Artist> getArtist(long id);

    Flowable<List<Track>> getTracks();
    Flowable<Track> getTrack(long id);
}
