package com.sasaj.lastfmapp;

import com.sasaj.lastfmapp.domain.entity.Chart;

import io.reactivex.Single;

/**
 * Created by sjugurdzija on 1/22/2018.
 */

public interface Repository {

    Single<Chart> getArtists();
}
