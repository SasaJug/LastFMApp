package com.sasaj.lastfmapp.domain.test;

import android.content.Context;

import com.sasaj.lastfmapp.di.HttpModule;
import com.sasaj.lastfmapp.httpclient.HttpClient;
import com.sasaj.lastfmapp.httpclient.RetrofitClient;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sjugurdzija on 3/5/2018.
 */

public class TestHttpModule extends HttpModule {

    public TestHttpModule(Context context) {
        super(context);
    }

    @Provides
        HttpClient provideHttpClient() {
            return Mockito.mock(RetrofitClient.class);
        }

    }

