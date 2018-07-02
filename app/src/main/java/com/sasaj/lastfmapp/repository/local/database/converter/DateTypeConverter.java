package com.sasaj.lastfmapp.repository.local.database.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Data type converter used by {@link android.arch.persistence.room.Room Room ORM}.
 */

public class DateTypeConverter {

    /**
     * Converts long date value to {@link Date date}.
     *
     * @param value Date long value.
     * @return {@link Date date}.
     */
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    /**
     * Converts {@link Date date} to long date value.
     *
     * @param date Date to be converted.
     * @return Long date value.
     */
    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
