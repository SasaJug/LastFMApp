package com.sasaj.lastfmapp.repository.local.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.sasaj.lastfmapp.domain.Artist;
import com.sasaj.lastfmapp.domain.Track;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sjugurdzija on 1/21/2018.
 */


public class DatabaseCreator implements LocalStorage {

    private LastFmDatabase lastFmDatabase;

    public DatabaseCreator(Context applicationContext) {
        lastFmDatabase = Room.databaseBuilder(applicationContext,
                LastFmDatabase.class, LastFmDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build();
    }

    // Artists
    @Override
    public Flowable<List<Artist>> getArtists() {
        return lastFmDatabase.artistDao().getAll();
    }

    @Override
    public Flowable<Artist> getArtist(long id) {
        return lastFmDatabase.artistDao().get(id);
    }

    @Override
    public void insertAllArtists(List<Artist> artists) {
        lastFmDatabase.artistDao().deleteAll();
        lastFmDatabase.artistDao().insertAll(artists);
    }

    // Tracks
    @Override
    public Flowable<List<Track>> getTracks() {
        return lastFmDatabase.trackDao().getAll();
    }

    @Override
    public Flowable<Track> getTrack(long id) {
        return lastFmDatabase.trackDao().get(id);
    }

    @Override
    public void insertAllTracks(List<Track> tracks) {
        lastFmDatabase.trackDao().deleteAll();
        lastFmDatabase.trackDao().insertAll(tracks);
    }
}