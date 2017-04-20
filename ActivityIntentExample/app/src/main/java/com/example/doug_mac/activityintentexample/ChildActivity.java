package com.example.doug_mac.activityintentexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        getIntentValues();
        getSharedPreferencesValues();

    }

    public void getIntentValues(){
        // Intent read
        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText(getIntent().getExtras().getString("userMessage"));
    }

    public void getSharedPreferencesValues(){

        // SharedPreferences
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String message = settings.getString("anotherMessage", null);

        TextView myTextView2 = (TextView) findViewById(R.id.textView2);
        myTextView2.setText(message);

        // Toast creates a small message-alert pop-up in your activity.
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();

        //If you want to create a custom SharedPreferences use this instead.
//        SharedPreferences myOwnSharedPreference = getSharedPreferences("MyOwnSharedPreference", Context.MODE_PRIVATE);
//        String myMessage = myOwnSharedPreference.getString("anotherMessage", "");
    }
}
