package com.sasaj.lastfmapp.domain;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.sasaj.lastfmapp.domain.converter.DateTypeConverter;
import com.sasaj.lastfmapp.domain.dao.ArtistDao;
import com.sasaj.lastfmapp.domain.dao.ImageDao;
import com.sasaj.lastfmapp.domain.dao.TrackDao;
import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Image;
import com.sasaj.lastfmapp.domain.entity.Track;

/**
 * Created by sjugurdzija on 1/21/2018.
 */

@Database(entities = {Artist.class, Image.class, Track.class}, version = 8, exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class LastFmDatabase extends RoomDatabase{

    public static final String DATABASE_NAME = "last_fm_db";

    public abstract ArtistDao artistDao();
    public abstract ImageDao imageDao();
    public abstract TrackDao trackDao();
}
