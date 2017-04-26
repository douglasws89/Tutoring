package com.example.doug_mac.tutoringsectionhw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        appInfo = AppInfo.getInstance(this);

        // Display Text on First String
        TextView myString1 = (TextView) findViewById(R.id.textViewString1);
        myString1.setText(appInfo.sharedStringOne);

        // Display Text on Second String
        TextView myString2 = (TextView) findViewById(R.id.textViewString2);
        myString2.setText(appInfo.sharedStringTwo);

    }
}
