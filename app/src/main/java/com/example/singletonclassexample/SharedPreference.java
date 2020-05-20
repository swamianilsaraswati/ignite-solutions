package com.example.singletonclassexample;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private static final String PREFS_NAME = "SingletonClassExample";
    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor prefEditor = null;
    private static Context context;
    public static SharedPreference instance = null;

    public static SharedPreference getInstance(Context context1){
        context = context1;
        if(instance == null){
            instance = new SharedPreference();
        }
        sharedPreferences = context1.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        prefEditor = sharedPreferences.edit();
        return instance;
    }

    public void setName(String name){
        prefEditor.putString("name",name);
        prefEditor.commit();
    }

    public String getName(){
        return sharedPreferences.getString("name","");
    }

    public void clearData(){
        prefEditor.clear();
        prefEditor.commit();
    }
}
