package com.sasaj.lastfmapp.domain;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.sasaj.lastfmapp.domain.converter.DateTypeConverter;
import com.sasaj.lastfmapp.domain.dao.ArtistDao;
import com.sasaj.lastfmapp.domain.dao.ImageDao;
import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Image;

/**
 * Created by DS on 1/21/2018.
 */

@Database(entities = {Artist.class, Image.class}, version = 1, exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class LastFmDatabase extends RoomDatabase{

    public static final String DATABASE_NAME = "last_fm_db";

    public abstract ArtistDao artistDao();
    public abstract ImageDao imageDao();
}
