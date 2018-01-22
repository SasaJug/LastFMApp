package com.sasaj.lastfmapp.domain;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by sjugurdzija on 1/21/2018.
 */


public class DatabaseCreator {

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static volatile LastFmDatabase sInstance;

    public static LastFmDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            LastFmDatabase.class, LastFmDatabase.DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }
}