package com.sasaj.lastfmapp.domain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
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
    @Query("SELECT * FROM images WHERE artist_mbid = :mbid")
    Flowable<List<Image>> getImagesForMbid(long mbid);

//    // Inserts single image
//    @Query("INSERT INTO images('artist_mbid','text','size') VALUES (:mbid, :text, :size)")
//    void insertImage(long mbid, String text, String size);
}
