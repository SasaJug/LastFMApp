package com.sasaj.lastfmapp.di;

import android.content.Context;

import com.sasaj.lastfmapp.repository.local.database.DatabaseCreator;
import com.sasaj.lastfmapp.repository.local.database.LocalStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sjugurdzija on 3/1/2018.
 */

@Module
public class LocalStorageModule {

    @Provides
    @Singleton
    LocalStorage provideLocalStorage(Context context){
        return new DatabaseCreator(context);
    }
}
