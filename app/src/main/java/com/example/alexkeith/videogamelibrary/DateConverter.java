package com.example.alexkeith.videogamelibrary;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by alexkeith on 4/12/18.
 */

public class DateConverter {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }
    @TypeConverter
    public static Long dateToTimestamp (Date date) {
        return date == null ? null : date.getTime();
    }
}
