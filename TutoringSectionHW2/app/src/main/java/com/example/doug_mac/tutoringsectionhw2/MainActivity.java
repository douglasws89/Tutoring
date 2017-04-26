package com.example.doug_mac.tutoringsectionhw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    AppInfo appInfo;

    static final public String MYPREFS = "myprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void onClickGoButton(View v){

        // Grab the value from the first edit text
        EditText editText1 = (EditText) findViewById(R.id.editTextString1);
        String myText1 = editText1.getText().toString();
        // Store the value from first edit text into appInfo
        appInfo.setMyString(1, myText1);


        // Grab the value from the second edit text
        EditText editText2 = (EditText) findViewById(R.id.editTextString2);
        String myText2 = editText2.getText().toString();
        // Store the value from second edit text into appInfo
        appInfo.setMyString(2, myText2);

        // Create intent to go to the next activity
        Intent intent = new Intent(this, Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
}
