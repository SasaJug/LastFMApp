package com.sasaj.lastfmapp.httpclient;

import android.content.Context;

import com.sasaj.lastfmapp.domain.entity.Chart;
import com.sasaj.lastfmapp.domain.entity.TopTracks;

import javax.inject.Singleton;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sjugurdzija on 1/18/2018.
 */

@Singleton
public class RetrofitClient implements HttpClient {

    public static final String API_URL = "http://ws.audioscrobbler.com/2.0/";
    public static final String API_KEY = "9a5c3e40b7b6f4846369794aa48daa60";
    public static final int LIMIT = 10;
    private Retrofit retrofit;
    private OkHttpClient client;

    private LastFmService service;

    public RetrofitClient(Context context) {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        OfflineMockInterceptor mockInterceptor = new OfflineMockInterceptor(context);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        client = okHttpBuilder.build();

        retrofit = new Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(LastFmService.class);
    }

    private LastFmService getService() {
        return service;
    }

    @Override
    public Single<Chart> getChartArtists(int page, int limit) {
        return getService().listChartArtists(API_KEY, page, limit);
    }

    @Override
    public Single<TopTracks> getChartTracks(int page, int limit) {
        return getService().listChartTracks(API_KEY, page, limit);
    }
}