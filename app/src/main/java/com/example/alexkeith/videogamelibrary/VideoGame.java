package com.example.alexkeith.videogamelibrary;

import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by alexkeith on 4/12/18.
 */

public class VideoGame {

    @PrimaryKey(autoGenerate = true)
    private int id;
        private String gameTitle;
        private String gameGenre;
        private Boolean isCheckedOut;
        private Date date;

        public VideoGame(String gameTitle, String gameGenre, Date date) {
            this.gameTitle = gameTitle;
            this.gameGenre = gameGenre;
            this.date = date;
        }

        public VideoGame() {

        }
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getGameTitle() { return gameTitle; }
        public void setGameTitle(String gameTitle) { this.gameTitle = gameTitle; }
        public String getGameGenre() { return gameGenre; }
        public void setGameGenre(String gameGenre) { this.gameGenre = gameGenre; }
        public boolean getIsCheckedOut() { return isCheckedOut; }
        public void setIsCheckedOut(boolean isCheckedOut) { this.isCheckedOut = isCheckedOut; }
        public Date getDate() {return date;}
        public void setDate(Date date) { this.date = date; }

}
