package com.sasaj.lastfmapp.domain.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sasaj.lastfmapp.domain.entity.Artist;

import java.lang.reflect.Type;

/**
 * Created by sjugurdzija on 3/10/2018.
 */

public class ArtistConverter {


    private static Gson gson = new Gson();

    @TypeConverter
    public static Artist stringToArtist(String data) {
        if (data == null) {
            return null;
        }

        Type artistType = new TypeToken<Artist>(){
        }.getType();

        return gson.fromJson(data, artistType);
    }

    @TypeConverter
    public static String artistToString(Artist artist) {
        return gson.toJson(artist);
    }
}
