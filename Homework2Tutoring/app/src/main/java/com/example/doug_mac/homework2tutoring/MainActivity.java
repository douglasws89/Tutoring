package com.example.doug_mac.homework2tutoring;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final public String MYPREFS = "myprefs";

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        EditText editText = (EditText) findViewById(R.id.editTextString1Content);
        if (appInfo.sharedStringOne != null) {
            editText.setText(appInfo.sharedStringOne);
        }

        TextView textViewString2 = (TextView) findViewById(R.id.textViewString2Content);
        if (appInfo.sharedStringTwo != null) {
            textViewString2.setText(appInfo.sharedStringTwo);
        }

        TextView textViewString3 = (TextView) findViewById(R.id.textViewString3Content);
        if (appInfo.sharedStringThree != null) {
            textViewString3.setText(appInfo.sharedStringThree);
        }
    }

    public void onClickEnter(View v){
        EditText editText = (EditText) findViewById(R.id.editTextString1Content);
        String text = editText.getText().toString();
        appInfo.setString("one", text);
    }

    public void onClickGoActivity2(View v){
        // Go to second activity
        Intent intent = new Intent(this, Activity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickGoActivity3(View v){
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
