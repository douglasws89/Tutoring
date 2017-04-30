package com.example.doug_mac.homework2tutoring;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Doug-Mac on 4/22/17.
 */

public class AppInfo {

    private static AppInfo instance = null;
    private static final String NAME_ONE = "One";
    private static final String NAME_TWO = "Two";
    private static final String NAME_THREE = "Three";

    protected AppInfo(){
        //Exists only to defeat instantiation
    }

    //Values we want to keep global
    public String sharedStringOne;
    public String sharedStringTwo;
    public String sharedStringThree;

    private Context my_context;

    public static AppInfo getInstance(Context context){
        if (instance == null) {
            instance = new AppInfo();
            instance.my_context = context;
            SharedPreferences settings = context.getSharedPreferences(MainActivity.MYPREFS, 0);
            instance.sharedStringOne = settings.getString(NAME_ONE, null);
            instance.sharedStringTwo = settings.getString(NAME_TWO, null);
            instance.sharedStringThree = settings.getString(NAME_THREE, null);
        }
        return instance;
    }

    public void setString(String number, String text){

        String tag;

        switch (number){
            case "one":
                tag = NAME_ONE;
                instance.sharedStringOne = text;
                break;
            case "two":
                tag = NAME_TWO;
                instance.sharedStringTwo = text;
                break;
            case "three":
                tag = NAME_THREE;
                instance.sharedStringThree = text;
                break;
            default:
                tag = "";
                break;
        }

        SharedPreferences settings = my_context.getSharedPreferences(MainActivity.MYPREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(tag, text);
        editor.commit();
    }

}
