package com.zookey.universalpreferences.objects;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Zoran on 09/09/2016.
 */
public interface UniversalObject {


    void put(String key, Object value);

    Object get(String key, Object defaultValue);

}
