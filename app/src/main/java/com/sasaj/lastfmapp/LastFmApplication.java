package com.sasaj.lastfmapp;

import android.app.Application;

import com.sasaj.lastfmapp.di.DaggerLastFmComponent;
import com.sasaj.lastfmapp.di.HttpModule;
import com.sasaj.lastfmapp.di.LastFmComponent;
import com.sasaj.lastfmapp.di.LastFmModule;
import com.sasaj.lastfmapp.di.LocalStorageModule;

/**
 * Created by sjugurdzija on 2/25/2018.
 */

public class LastFmApplication extends Application {

    private LastFmComponent lastFmComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        lastFmComponent = createLastFmComponent();
    }

    public LastFmComponent getLastFmComponent() {
        return lastFmComponent;
    }


    public LastFmComponent createLastFmComponent() {
        return DaggerLastFmComponent
                .builder()
                .lastFmModule(new LastFmModule())
                .httpModule(new HttpModule(getApplicationContext()))
                .localStorageModule(new LocalStorageModule())
                .build();
    }

}
