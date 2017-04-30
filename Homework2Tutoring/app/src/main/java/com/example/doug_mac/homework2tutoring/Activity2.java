package com.example.doug_mac.homework2tutoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView textViewString1 = (TextView) findViewById(R.id.textViewString1Content);
        if (appInfo.sharedStringOne != null) {
            textViewString1.setText(appInfo.sharedStringOne);
        }

        EditText editText = (EditText) findViewById(R.id.editTextString2Content);
        if (appInfo.sharedStringTwo != null) {
            editText.setText(appInfo.sharedStringTwo);
        }

        TextView textViewString3 = (TextView) findViewById(R.id.textViewString3Content);
        if (appInfo.sharedStringThree != null) {
            textViewString3.setText(appInfo.sharedStringThree);
        }
    }

    public void onClickEnter(View v){
        EditText editText = (EditText) findViewById(R.id.editTextString2Content);
        String text = editText.getText().toString();
        appInfo.setString("two", text);
    }

    public void onClickGoMainActivity(View v){
        // Go to second activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickGoActivity3(View V){
        // Go to second activity
        Intent intent = new Intent(this, Activity3.class);
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
