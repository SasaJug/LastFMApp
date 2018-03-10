package com.sasaj.lastfmapp.domain.test;

import com.sasaj.lastfmapp.domain.Repository;
import com.sasaj.lastfmapp.di.LastFmModule;
import com.sasaj.lastfmapp.domain.LastFmRepository;
import com.sasaj.lastfmapp.domain.LocalStorage;
import com.sasaj.lastfmapp.httpclient.HttpClient;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by sjugurdzija on 3/5/2018.
 */

public class TestLastFmModule extends LastFmModule{
    @Provides
    @Singleton
    Repository provideRepository(HttpClient client, LocalStorage storage) {
        return Mockito.mock(LastFmRepository.class);
    }
}
