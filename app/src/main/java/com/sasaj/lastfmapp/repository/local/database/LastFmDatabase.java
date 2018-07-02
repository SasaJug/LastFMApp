package com.sasaj.lastfmapp.repository.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.sasaj.lastfmapp.repository.local.database.converter.DateTypeConverter;
import com.sasaj.lastfmapp.repository.local.database.dao.ArtistDao;
import com.sasaj.lastfmapp.repository.local.database.dao.TrackDao;
import com.sasaj.lastfmapp.domain.Artist;
import com.sasaj.lastfmapp.domain.Track;

/**
 * Created by sjugurdzija on 1/21/2018.
 */

@Database(entities = {Artist.class, Track.class}, version = 9, exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class LastFmDatabase extends RoomDatabase{

    public static final String DATABASE_NAME = "last_fm_db";

    public abstract ArtistDao artistDao();
    public abstract TrackDao trackDao();
}
