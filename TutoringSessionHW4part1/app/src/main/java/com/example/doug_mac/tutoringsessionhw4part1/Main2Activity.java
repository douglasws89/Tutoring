package com.example.doug_mac.tutoringsessionhw4part1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Read from Intent
        TextView myTextView = (TextView) findViewById(R.id.url);
        myTextView.setText(getIntent().getExtras().getString("url"));
    }
}
