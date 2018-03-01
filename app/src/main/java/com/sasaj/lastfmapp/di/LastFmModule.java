package com.sasaj.lastfmapp.di;

import android.content.Context;

import com.sasaj.lastfmapp.Repository;
import com.sasaj.lastfmapp.domain.LastFmRepository;
import com.sasaj.lastfmapp.domain.LocalStorage;
import com.sasaj.lastfmapp.httpclient.HttpClient;

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
