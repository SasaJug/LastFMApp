package com.sasaj.lastfmapp.domain.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sasaj.lastfmapp.domain.entity.Image;
import com.sasaj.lastfmapp.domain.entity.Streamable;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by sjugurdzija on 3/10/2018.
 */

public class StreamableConverter {

        private static Gson gson = new Gson();

        @TypeConverter
        public static Streamable stringToStreamable(String data) {
            if (data == null) {
                return null;
            }

            Type streamableType = new TypeToken<Streamable> (){
            }.getType();

            return gson.fromJson(data, streamableType);
        }

        @TypeConverter
        public static String streamableToString(Streamable streamable) {
            return gson.toJson(streamable);
        }
}
