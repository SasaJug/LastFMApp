package com.sasaj.lastfmapp.di;

import com.sasaj.lastfmapp.repository.Repository;
import com.sasaj.lastfmapp.repository.LastFmRepository;
import com.sasaj.lastfmapp.repository.local.database.LocalStorage;
import com.sasaj.lastfmapp.repository.remote.httpclient.HttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sjugurdzija on 2/25/2018.
 */

@Module
public class LastFmModule {

    @Provides
    @Singleton
    Repository provideRepository(HttpClient client, LocalStorage storage) {
        return new LastFmRepository(client, storage);
    }

}
