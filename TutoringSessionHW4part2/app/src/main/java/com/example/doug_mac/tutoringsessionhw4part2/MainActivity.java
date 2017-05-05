package com.example.doug_mac.tutoringsessionhw4part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = "TutoringSessionHW4part2";

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        getList();

    }

    private void getList() {

        final TextView title = (TextView) findViewById(R.id.title);
        final TextView subtitle = (TextView) findViewById(R.id.subtitle);
        final TextView urlTextView = (TextView) findViewById(R.id.url);


        // Instantiate the RequestQueue.
        final String url = "https://luca-ucsc-teaching-backend.appspot.com/hw4/get_news_sites";

        final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(LOG_TAG, "Received: " + response.toString());
                        // Ok, let's disassemble a bit the json object.
                        try {
                            JSONArray receivedList = response.getJSONArray("news_sites");
                            for (int i = 0; i < receivedList.length(); i++) {
                                JSONObject object = new JSONObject(receivedList.getString(i));
                                title.setText("Title: " + object.getString("title"));
                                subtitle.setText("Subtitle: " + object.getString("subtitle"));
                                urlTextView.setText("URL: " + object.getString("url"));

                                Log.d(LOG_TAG, "Received List: " + receivedList.getString(i));
                            }
                        } catch (Exception e) {
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d(LOG_TAG, error.toString());
                    }
                });

        // In some cases, we don't want to cache the request.
        // jsObjRequest.setShouldCache(false);
        queue.add(jsObjRequest);
    }

    public void onClickRefresh(View v){
        getList();
    }
}
