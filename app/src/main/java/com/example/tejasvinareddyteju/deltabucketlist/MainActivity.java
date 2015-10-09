package com.example.tejasvinareddyteju.deltabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    public static BucketListDriver bucketListDriver = new BucketListDriver();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();

        String[] userBucketListItems = BucketListDriver.destinationToStringAwway(bucketListDriver.bucketListToArray());
        listView = (ListView) findViewById(R.id.bucketlistListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, userBucketListItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                //FIXME takes in a string
                String itemValue = (String) listView.getItemAtPosition(position);

                Intent intent = new Intent(view.getContext(), DestinationInformationActivity.class);
                intent.putExtra("DESTINATION_TO_VIEW", itemValue);
                startActivity(intent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Called when the user pressed the FAB
    public void addNewItem(View view) {
        Intent intent = new Intent(this, AddDestinationActivity.class);
        startActivity(intent);
    }
}
