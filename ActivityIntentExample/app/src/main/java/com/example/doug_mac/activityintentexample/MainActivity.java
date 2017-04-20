package com.example.doug_mac.activityintentexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Another way of creating a onClick Listener
//        Button myButton = (Button) findViewById(R.id.button);
//
//        myButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ChildActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    public void goToNewActivity(View v){

        EditText myText = (EditText) findViewById(R.id.editText);

        putSharedPreferenceValues(myText);
        putIntentValues(myText);

    }

    public void putSharedPreferenceValues(EditText editText){
        // Default Shared preferences (recommended by professor)
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("anotherMessage", (editText.getText().toString() + ", right?"));
        editor.apply();

        //Custom SharedPreferences
        //SharedPreferences myOwnSharedPreference = getSharedPreferences("MyOwnSharedPreference", Context.MODE_PRIVATE);
    }

    public void putIntentValues(EditText editText){
        // Intents
        Intent intent = new Intent(this, ChildActivity.class);
        intent.putExtra("userMessage", editText.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Clear EditText when activity comes back live, AKA onResume().
        EditText myText = (EditText) findViewById(R.id.editText);
        myText.setText("");
    }
}
