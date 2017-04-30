package com.example.doug_mac.homework2tutoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView textViewString1 = (TextView) findViewById(R.id.textViewString1Content);
        if (appInfo.sharedStringOne != null) {
            textViewString1.setText(appInfo.sharedStringOne);
        }

        TextView textViewString2 = (TextView) findViewById(R.id.textViewString2Content);
        if (appInfo.sharedStringTwo != null) {
            textViewString2.setText(appInfo.sharedStringTwo);
        }

        EditText editText = (EditText) findViewById(R.id.editTextString3Content);
        if (appInfo.sharedStringThree != null) {
            editText.setText(appInfo.sharedStringThree);
        }
    }

    public void onClickEnter(View v){
        EditText editText = (EditText) findViewById(R.id.editTextString3Content);
        String text = editText.getText().toString();
        appInfo.setString("three", text);
    }

    public void onClickGoMainActivity(View v){
        // Go to second activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickGoActivity2(View v){
        // Go to second activity
        Intent intent = new Intent(this, Activity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
