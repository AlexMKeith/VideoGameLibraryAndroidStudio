package com.example.alexkeith.videogamelibrary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by alexkeith on 4/12/18.
 */
@Dao
public interface VideoGameDao {
    //Allows us to get all videogame, Allows us to add a single game to the list, Allows us to update the values of an existing game, Allows us to delete a game from the library
    @Query("SELECT * FROM videogame")
    List<VideoGame> getVideoGames();
    @Insert
    void addVideoGame(VideoGame videoGame);
    @Update
    void updateVideoGame(VideoGame videoGame);
    @Delete
    void deleteVideoGame(VideoGame videoGame);
}
