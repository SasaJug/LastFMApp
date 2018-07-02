package com.sasaj.lastfmapp.repository.remote.httpclient;

import com.sasaj.lastfmapp.domain.Chart;
import com.sasaj.lastfmapp.domain.TopTracks;

import io.reactivex.Single;

/**
 * Created by sjugurdzija on 2/25/2018.
 */

public interface HttpClient {
    Single<Chart> getChartArtists(int page, int limit);
    Single<TopTracks> getChartTracks(int page, int limit);
}
