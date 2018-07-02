package com.sasaj.lastfmapp.repository.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sasaj.lastfmapp.domain.Artist;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sjugurdzija on 1/21/2018.
 */

@Dao // Required annotation for Dao to be recognized by Room
public interface ArtistDao {
    // Returns a list of all artists in the database
    @Query("SELECT * FROM artists")
    Flowable<List<Artist>> getAll();

    // Returns single artist
    @Query("SELECT * FROM artists WHERE id = :id LIMIT 1")
    Flowable<Artist> get(long id);

    // Inserts multiple artists
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Artist> artists);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Artist artist);

    // Deletes a single artist
    @Delete
    void delete(Artist artist);

    @Query("DELETE FROM artists")
    void deleteAll();
}
