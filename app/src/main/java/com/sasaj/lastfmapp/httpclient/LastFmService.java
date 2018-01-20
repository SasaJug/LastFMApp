package com.sasaj.lastfmapp.httpclient;

import com.sasaj.lastfmapp.domain.Chart;
import com.sasaj.lastfmapp.domain.TopTracks;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DS on 1/18/2018.
 */

public interface LastFmService {

    @GET("?method=chart.gettopartists&format=json")
    Single<Chart> listChartArtists(@Query("api_key") String apiKey,
                                   @Query("page") int page,
                                   @Query("limit") int limit);


    @GET("?method=chart.gettoptracks&format=json")
    Single<TopTracks> listChartTracks(@Query("api_key") String apiKey,
                                      @Query("page") int page,
                                      @Query("limit") int limit);
}
