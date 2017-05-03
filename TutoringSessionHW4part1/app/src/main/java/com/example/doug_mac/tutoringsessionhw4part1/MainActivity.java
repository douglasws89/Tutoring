package com.example.doug_mac.tutoringsessionhw4part1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String [] titleOfNews = {"New York Times", "Washington Post", "San Francisco Chronicle", "Fox News"};
    String [] subtitleOfNews = {"Trump Crazy!", "Trump is ruining the country!", "Trump will kill us all!", "Trump is the best president in the world!"};
    String [] urlOfNews = {"http://nyt","http://wp","http://sfc","http://fn"};

    private static final String LOG_TAG = "lv-ex";

    private class ListElement {
        ListElement() {};

        ListElement(String tl, String subtl, String myURL) {
            title = tl;
            subtitle = subtl;
            url = myURL;
        }

        public String title;
        public String subtitle;
        public String url;
    }

    private ArrayList<ListElement> aList;

    private class MyAdapter extends ArrayAdapter<ListElement> {

        int resource;
        Context context;

        public MyAdapter(Context _context, int _resource, List<ListElement> items) {
            super(_context, _resource, items);
            resource = _resource;
            context = _context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            RelativeLayout newView;

            ListElement item = getItem(position);

            // Inflate a new view if necessary.
            if (convertView == null) {
                newView = new RelativeLayout(getContext());
                LayoutInflater vi = (LayoutInflater)
                        getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vi.inflate(resource,  newView, true);
            } else {
                newView = (RelativeLayout) convertView;
            }

            // Fills in the view.
            TextView titleTextView = (TextView) newView.findViewById(R.id.title);
            TextView  subtitleTextView= (TextView) newView.findViewById(R.id.subtitle);

            titleTextView.setText(item.title);
            subtitleTextView.setText(item.subtitle);

            // Set a listener for the whole list item.
            newView.setTag(item.url);
            newView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Action to do when cell is clicked
                    String s = v.getTag().toString();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, s, duration);
                    toast.show();

                    // Intent to go to next activity passing url
                    Intent intent = new Intent(context, Main2Activity.class);
                    intent.putExtra("url", v.getTag().toString());
                    startActivity(intent);
                }
            });

            return newView;
        }
    }

    private MyAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aList = new ArrayList<ListElement>();
        aa = new MyAdapter(this, R.layout.list_element, aList);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(aa);
        aa.notifyDataSetChanged();
        loadCell();
    }


    public void clickRefresh (View v) {
        loadCell();
    }

    public void loadCell(){
        Log.i(LOG_TAG, "Requested a refresh of the list");
//        ListElement myList = new ListElement();
        aList.clear();
        for (int i = 0; i < titleOfNews.length; i++) {
            aList.add(new ListElement(
                    this.titleOfNews[i], this.subtitleOfNews[i], this.urlOfNews[i]
            ));
        }

        // We notify the ArrayList adapter that the underlying list has changed,
        // triggering a re-rendering of the list.
        Toast toast = Toast.makeText(getBaseContext(), "New Headline added", Toast.LENGTH_SHORT);
        toast.show();
        aa.notifyDataSetChanged();
    }
}
