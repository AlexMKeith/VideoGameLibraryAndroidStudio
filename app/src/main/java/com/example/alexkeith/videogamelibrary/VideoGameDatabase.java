package com.example.alexkeith.videogamelibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

/**
 * Created by alexkeith on 4/16/18.
 */

@Database(version = 1, entities = VideoGame.class)
@TypeConverters(DateConverter.class)

public abstract class VideoGameDatabase extends RoomDatabase {
    public abstract VideoGameDao videoGameDao();
}
