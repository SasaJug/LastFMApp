package com.sasaj.lastfmapp.utility;

import android.content.Context;

import com.sasaj.lastfmapp.Repository;
import com.sasaj.lastfmapp.domain.LastFmRepository;

/**
 * Created by sjugurdzija on 1/22/2018.
 */

public class InjectorUtils {

    public static Repository provideRepository(Context context){
        return LastFmRepository.getInstance(context);
    }
}
