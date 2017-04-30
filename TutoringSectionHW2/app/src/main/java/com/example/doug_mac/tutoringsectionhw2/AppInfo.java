package com.example.doug_mac.tutoringsectionhw2;

/**
 * Created by Doug-Mac on 4/25/17.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class AppInfo {

    private static AppInfo instance = null;
    // Updated this to be equal to a string "ONE" and "TWO"
    private static final String MY_TEXT_ONE = "ONE";
    private static final String MY_TEXT_TWO = "TWO";


    protected AppInfo() {
        // Exists only to defeat instantiation.
    }

    // Here are some values we want to keep global.
    public String sharedStringOne;
    public String sharedStringTwo;


    private Context my_context;

    public static AppInfo getInstance(Context context) {
        if(instance == null) {
            instance = new AppInfo();
            instance.my_context = context;
            SharedPreferences settings = context.getSharedPreferences(MainActivity.MYPREFS, 0);
            instance.sharedStringOne = settings.getString(MY_TEXT_ONE, null);
            instance.sharedStringTwo = settings.getString(MY_TEXT_TWO, null);
        }
        return instance;
    }

    public void setMyString(Integer sttringNumber, String c) {

        String stringKey = "";

        // Store the value of either First or Second String
        switch (sttringNumber){
            case(1):
                stringKey = MY_TEXT_ONE;
                instance.sharedStringOne = c;
                break;
            case(2):
                stringKey = MY_TEXT_TWO;
                instance.sharedStringTwo = c;
                break;
            default:
                break;
        }

        SharedPreferences settings = my_context.getSharedPreferences(MainActivity.MYPREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(stringKey, c);
        editor.commit();
    }

}
