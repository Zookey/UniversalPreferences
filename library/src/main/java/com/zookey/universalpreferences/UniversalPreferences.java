package com.zookey.universalpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;

import com.zookey.universalpreferences.objects.UniversalObject;
import com.zookey.universalpreferences.objects.concrete.BooleanObject;
import com.zookey.universalpreferences.objects.concrete.FloatObject;
import com.zookey.universalpreferences.objects.concrete.IntegerObject;
import com.zookey.universalpreferences.objects.concrete.LongObject;
import com.zookey.universalpreferences.objects.concrete.StringObject;
import com.zookey.universalpreferences.objects.concrete.StringSetObject;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;


/**
 * Created by Zoran on 09/09/2016.
 */
public class UniversalPreferences {

    public static UniversalPreferences instance;
    private static SharedPreferences prefs;

    public static void initialize(Context context, String prefsName){
        if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        }
        if(prefsName == null || prefsName.equals("")){
            throw new IllegalArgumentException("Preference name can not be null or empty");
        }
        prefs = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
    }

    public static void initialize(Context context){
        if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        }
        prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public static synchronized UniversalPreferences getInstance(){
        if(instance == null){
            return instance = new UniversalPreferences();
        }
        return instance;
    }

    public void put(String key, Object value){
        UniversalObject universalObject;
        if(value instanceof String){
            universalObject = new StringObject(prefs);
            universalObject.put(key, value);
        } else if(value instanceof  Boolean) {
            universalObject = new BooleanObject(prefs);
            universalObject.put(key, value);
        } else if(value instanceof  Integer) {
            universalObject = new IntegerObject(prefs);
            universalObject.put(key, value);
        } else if(value instanceof  Long) {
            universalObject = new LongObject(prefs);
            universalObject.put(key, value);
        } else if(value instanceof  Float) {
            universalObject = new FloatObject(prefs);
            universalObject.put(key, value);
        } else if(value instanceof Set){
            universalObject = new StringSetObject(prefs);
            universalObject.put(key, value);
        } else{
            throw new ClassCastException(value.getClass().getName()+" is not allowed type of object.");
        }
    }


    public <T extends Object> T get(String key, Object defaultValue){
        UniversalObject universalObject;
        if(defaultValue instanceof String){
            universalObject = new StringObject(prefs);
            return (T) universalObject.get(key, defaultValue);
        } else if(defaultValue instanceof  Boolean) {
            universalObject = new BooleanObject(prefs);
            return (T) universalObject.get(key, defaultValue);
        } else if(defaultValue instanceof  Integer) {
            universalObject = new IntegerObject(prefs);
            return (T) universalObject.get(key, defaultValue);
        } else if(defaultValue instanceof  Long) {
            universalObject = new LongObject(prefs);
            return (T) universalObject.get(key, defaultValue);
        } else if(defaultValue instanceof  Float) {
            universalObject = new FloatObject(prefs);
            return (T) universalObject.get(key, defaultValue);
        } else if(defaultValue instanceof Set){
            universalObject = new StringSetObject(prefs);
            return (T) universalObject.get(key, defaultValue);
        } else{
            throw new ClassCastException(defaultValue.getClass().getName()+" is not allowed type of object.");
        }
    }


    public Map<String, ?> getAll(){
        return prefs.getAll();
    }

    public boolean contains(String key){
        return prefs.contains(key);
    }

    public void clear(){
        prefs.edit().clear().apply();
    }

    public void remove(String key){
        prefs.edit().remove(key).apply();
    }
}
