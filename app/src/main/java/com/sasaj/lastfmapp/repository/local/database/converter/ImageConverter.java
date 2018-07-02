package com.sasaj.lastfmapp.repository.local.database.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sasaj.lastfmapp.domain.Image;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by sjugurdzija on 1/23/2018.
 */

public class ImageConverter {

    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Image> stringToImageList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Image>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String imageListToString(List<Image> Images) {
        return gson.toJson(Images);
    }
}

