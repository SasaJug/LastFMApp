package com.sasaj.lastfmapp.di;

import com.sasaj.lastfmapp.repository.Repository;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by sjugurdzija on 2/25/2018.
 */

    @Singleton
    @Component(modules = {LastFmModule.class, HttpModule.class, LocalStorageModule.class})
    public interface LastFmComponent {
        Repository getRepository();
    }

