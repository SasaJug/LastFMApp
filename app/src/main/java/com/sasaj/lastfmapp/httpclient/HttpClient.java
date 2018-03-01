package com.sasaj.lastfmapp.httpclient;

import com.sasaj.lastfmapp.domain.entity.Chart;
import com.sasaj.lastfmapp.domain.entity.TopTracks;

import io.reactivex.Single;

/**
 * Created by sjugurdzija on 2/25/2018.
 */

public interface HttpClient {
    Single<Chart> getChartArtists(int page, int limit);
    Single<TopTracks> getChartTracks(int page, int limit);
}
