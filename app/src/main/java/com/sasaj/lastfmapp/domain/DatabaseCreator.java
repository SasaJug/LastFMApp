package com.sasaj.lastfmapp.domain;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Image;
import com.sasaj.lastfmapp.domain.entity.Track;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sjugurdzija on 1/21/2018.
 */


public class DatabaseCreator implements LocalStorage{

    private LastFmDatabase lastFmDatabase;

    public DatabaseCreator(Context applicationContext) {
        lastFmDatabase = Room.databaseBuilder(applicationContext,
                LastFmDatabase.class, LastFmDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build();
    }

    public Flowable<List<Artist>> getArtists() {
        return lastFmDatabase.artistDao().getAll();
    }

    @Override
    public Flowable<Artist> getArtist(String mbid) {
        return lastFmDatabase.artistDao().get(mbid);
    }

    @Override
    public Flowable<List<Image>> getImages(String mbid) {
        return lastFmDatabase.imageDao().getImagesForMbid(mbid);
    }

    @Override
    public void insertAllArtists(List<Artist> artists) {
        lastFmDatabase.artistDao().insertAll(artists);
        for (Artist artist : artists) {
            for(Image image : artist.getImage())
                lastFmDatabase.getOpenHelper().getWritableDatabase()
                        .execSQL("Insert into images(text, size, artist_mbid) values(?,?,?)",new String[]{image.getText(), image.getSize(), artist.getMbid()});
        }
    }

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
        lastFmDatabase.trackDao().insertAll(tracks);
    }
}