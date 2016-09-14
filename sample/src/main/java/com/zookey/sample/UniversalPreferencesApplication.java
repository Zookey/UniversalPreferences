package com.zookey.sample;

import android.app.Application;

import com.zookey.universalpreferences.UniversalPreferences;

/**
 * Created by Zoran on 14/09/2016.
 */
public class UniversalPreferencesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UniversalPreferences.initialize(this);
    }
}
