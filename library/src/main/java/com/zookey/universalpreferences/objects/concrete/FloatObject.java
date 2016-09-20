package com.zookey.universalpreferences.objects.concrete;

import android.content.SharedPreferences;

import com.zookey.universalpreferences.objects.UniversalObject;

/**
 * Created by Zoran on 09/09/2016.
 */
public class FloatObject implements UniversalObject {

    private SharedPreferences prefs;

    public  FloatObject(SharedPreferences prefs){
        this.prefs = prefs;
    }

    @Override
    public void put(String key, Object value) {
        prefs.edit().putFloat(key, (Float) value).apply();
    }

    @Override
    public Object get(String key, Object defaultValue) {
        return prefs.getFloat(key, (Float) defaultValue);
    }
}