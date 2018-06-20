package com.sasaj.lastfmapp.repository.remote.httpclient;

import com.sasaj.lastfmapp.domain.entity.Chart;
import com.sasaj.lastfmapp.domain.entity.TopTracks;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sjugurdzija on 1/18/2018.
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
