package com.example.singletonclassexample;

import android.content.Context;
import android.content.SharedPreferences;

/* shared preference class to be used by the application
 * which implements singleton class design pattern
 * */
public class SharedPreference {
    //preference name
    private static final String PREFS_NAME = "SingletonClassExample";
    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor prefEditor = null;
    private static Context context;
    public static SharedPreference instance = null;

    //to create only one instance
    public static SharedPreference getInstance(Context context1){
        context = context1;
        //checks if first time creating the object or not
        if(instance == null){
            //creates first time instance
            instance = new SharedPreference();
        }
        sharedPreferences = context1.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        prefEditor = sharedPreferences.edit();
        return instance;
    }

    //setter function for name
    public void setName(String name){
        prefEditor.putString("name",name);
        prefEditor.commit();
    }

    //getter function for name
    public String getName(){
        return sharedPreferences.getString("name","");
    }

    //clears shared preferences
    public void clearData(){
        prefEditor.clear();
        prefEditor.commit();
    }
}
