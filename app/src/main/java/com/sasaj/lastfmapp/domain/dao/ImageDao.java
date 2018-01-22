package com.sasaj.lastfmapp.domain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sasaj.lastfmapp.domain.entity.Image;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by DS on 1/21/2018.
 */

@Dao
public interface ImageDao {

    // Returns single image
    @Query("SELECT * FROM images WHERE mbid = :mbid")
    Flowable<List<Image>> getImagesForMbid(long mbid);

    // Inserts multiple images
    @Insert
    void insertAll(Image... images);
}
