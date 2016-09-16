package com.zookey.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.zookey.universalpreferences.UniversalPreferences;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UniversalPreferences.getInstance().put("string", "some value");
        String string =  UniversalPreferences.getInstance().get("string", "");
        Log.d("String", string);

        // boolean
        UniversalPreferences.getInstance().put("bool", true);
        boolean bool = UniversalPreferences.getInstance().get("bool", false);
        Log.d("boolean", String.valueOf(bool));

        // int
        UniversalPreferences.getInstance().put("int", 30);
        int value =  UniversalPreferences.getInstance().get("int", 0);
        Log.d("int", String.valueOf(value));

        // float
        UniversalPreferences.getInstance().put("float", 3.0f);
        float valueFloat = UniversalPreferences.getInstance().get("float", 0.0f);
        Log.d("float", String.valueOf(valueFloat));

        // Set<String>
        Set<String> set = new HashSet<String>();
        set.add("test 1");
        set.add("test 2");
        UniversalPreferences.getInstance().put("set", set);
        Set<String> savedSet = UniversalPreferences.getInstance().get("set", new HashSet<>());
        for (String s : savedSet) {
            Log.d("Set", String.valueOf(s));
        }

        //This will get default value, since there is no value with this key
        int noValue =  UniversalPreferences.getInstance().get("novalue", 0);
        Log.d("int", String.valueOf(noValue));
        
    }
}
