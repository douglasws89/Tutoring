package com.example.doug_mac.homework3tutoring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = "Homework3Tutoring";

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    //Send Message method from sample code
    private void postMessage(final String token) {

        final TextView myText = (TextView) findViewById(R.id.textView);

        StringRequest sr = new StringRequest(Request.Method.POST,
                "http://luca-ucsc-teaching-backend.appspot.com/hw3/request_via_post",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(LOG_TAG, "Got:" + response);

                        JSONObject result = null;
                        try {
                            result = new JSONObject(response);
                            String name = result.getString("result");
                            myText.setText(name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("token", token);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(sr);
    }

    //Get Message method from sample code
    private void getMessage(final String recipient) {

        final TextView myText = (TextView) findViewById(R.id.textView);

        // Instantiate the RequestQueue.
        String url = "https://luca-ucsc-teaching-backend.appspot.com/hw3/request_via_get";

        String my_url = url + "?token=" + URLEncoder.encode(recipient);



        Log.d(LOG_TAG, "String Passed: " + my_url);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, my_url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(LOG_TAG, "Received: " + response.toString());

                        try {
                            String name = response.getString("result");
                            myText.setText(name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // Ok, let's disassemble a bit the json object.
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

    public void onClickGet(View v){
        getMessage("abracadabra");
    }

    public void onClickPost(View v){
        postMessage("abracadabra");
    }

}
