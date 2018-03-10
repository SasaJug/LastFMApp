package com.sasaj.lastfmapp.domain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sasaj.lastfmapp.domain.entity.Image;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sjugurdzija on 1/21/2018.
 */

@Dao
public interface ImageDao {

    // Returns all images for specified mbid
    @Query("SELECT * FROM images WHERE artist_mbid = :mbid")
    Flowable<List<Image>> getImagesForMbid(String mbid);

    @Query("SELECT * FROM images WHERE artist_mbid = :mbid AND size = 'thumbnail'")
    Flowable<List<Image>> getArtistThumbnail(String mbid);

}
