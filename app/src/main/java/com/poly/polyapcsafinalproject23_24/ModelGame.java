package com.poly.polyapcsafinalproject23_24;

import android.app.Activity;

import java.io.Serializable;

public class ModelGame implements Serializable {

    private final Activity ACTIVITY;
    private final String AUTHOR_FIRST_NAME;
    private final String AUTHOR_LAST_NAME;
    private final String GAME_NAME;

    public ModelGame(String authorFirstName, String authorLastName, String gameName, Activity activity) {
        this.ACTIVITY = activity;
        this.AUTHOR_FIRST_NAME = authorFirstName;
        this.AUTHOR_LAST_NAME = authorLastName;
        this.GAME_NAME = gameName;
    }

    public String getAuthorFirstname() {
        return AUTHOR_FIRST_NAME;
    }

    public String getAuthorLastname() {
        return AUTHOR_LAST_NAME;
    }

    public String getAuthorName() {
        return AUTHOR_FIRST_NAME + " " + AUTHOR_LAST_NAME;
    }

    public String getGameName() {
        return GAME_NAME;
    }

    public Activity getActivity() {
        return ACTIVITY;
    }
}
