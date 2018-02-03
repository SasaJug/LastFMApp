package com.sasaj.lastfmapp.domain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sasaj.lastfmapp.domain.entity.Artist;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by DS on 1/21/2018.
 */

@Dao // Required annotation for Dao to be recognized by Room
public interface ArtistDao {
    // Returns a list of all artists in the database
    @Query("SELECT * FROM artists")
    Flowable<List<Artist>> getAll();

    // Returns single artist
    @Query("SELECT * FROM artists WHERE mbid = :mbid LIMIT 1")
    Flowable<Artist> get(String mbid);

    // Inserts multiple artists
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Artist> artists);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Artist artist);

    // Deletes a single artist
    @Delete
    void delete(Artist artist);
}
