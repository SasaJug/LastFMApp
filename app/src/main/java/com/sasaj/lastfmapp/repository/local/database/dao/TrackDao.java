package com.sasaj.lastfmapp.repository.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sasaj.lastfmapp.domain.Track;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sjugurdzija on 3/10/2018.
 */

@Dao
public interface TrackDao {

        // Returns a list of all tracks in the database
        @Query("SELECT * FROM tracks")
        Flowable<List<Track>> getAll();

        // Returns single track
        @Query("SELECT * FROM tracks WHERE id = :id LIMIT 1")
        Flowable<Track> get(long id);

        // Inserts multiple tracks
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<Track> tracks);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        long insert(Track track);

        // Deletes a single track
        @Delete
        void delete(Track track);

        @Query("DELETE FROM tracks")
        public void deleteAll();

}
