package com.sasaj.lastfmapp.di;

import android.content.Context;

import com.sasaj.lastfmapp.httpclient.HttpClient;
import com.sasaj.lastfmapp.httpclient.RetrofitClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sjugurdzija on 2/27/2018.
 */

@Module
public class HttpModule {


    private final Context context;

    public HttpModule(Context context){
        this.context = context;
    }

    @Provides
    HttpClient provideHttpClient() {
        return new RetrofitClient();
    }


    @Provides
    Context provideApplicationContext() {
        return context;
    }
}
