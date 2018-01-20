package com.sasaj.lastfmapp.httpclient;

import com.sasaj.lastfmapp.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DS on 1/18/2018.
 */

public class RetrofitClient {

    public static final String API_URL = "http://ws.audioscrobbler.com/2.0/";
    public static final String API_KEY = "9a5c3e40b7b6f4846369794aa48daa60";
    public static final int LIMIT = 10;
    private static RetrofitClient instance = null;
    private Retrofit retrofit;
    private OkHttpClient client;

    private LastFmService service;

    public RetrofitClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
//        okHttpBuilder.addInterceptor(new TokenInterceptor());

        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(loggingInterceptor);
        }

        client = okHttpBuilder.build();

        retrofit = new Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(LastFmService.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }

        return instance;
    }

    public LastFmService getService() {
        return service;
    }
}