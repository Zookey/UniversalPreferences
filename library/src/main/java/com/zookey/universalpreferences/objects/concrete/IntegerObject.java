package com.zookey.universalpreferences.objects.concrete;

import android.content.SharedPreferences;

import com.zookey.universalpreferences.objects.UniversalObject;

/**
 * Created by Zoran on 09/09/2016.
 */
public class IntegerObject implements UniversalObject {

    private SharedPreferences prefs;

    public  IntegerObject(SharedPreferences prefs){
        this.prefs = prefs;
    }

    @Override
    public void put(String key, Object value) {
        prefs.edit().putInt(key, (Integer) value).apply();
    }

    @Override
    public Object get(String key, Object defaultValue) {
        return prefs.getInt(key, (Integer) defaultValue);
    }
}
