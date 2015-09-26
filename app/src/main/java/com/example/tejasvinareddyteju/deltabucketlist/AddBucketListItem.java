package com.example.tejasvinareddyteju.deltabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AddBucketListItem extends Activity {
    private ListView listView;

    private BucketListDriver bucketListDriver = MainActivity.bucketListDriver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_add_bucket_list_item);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.addLocationsListView);

        // Defined Array values to show in ListViews
        // Import all the values over here
        String[] possibleLocations = bucketListDriver.possibleDestinationsToArray();

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, possibleLocations);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                bucketListDriver.addDestination(bucketListDriver.findDestinationByName(itemValue));
                Toast.makeText(getApplicationContext(),
                        "Added destination: " + itemValue, Toast.LENGTH_SHORT)
                        .show();

            }

        });
    }

}
