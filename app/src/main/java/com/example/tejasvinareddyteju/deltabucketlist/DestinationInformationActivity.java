package com.example.tejasvinareddyteju.deltabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class DestinationInformationActivity extends Activity {


    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_information);

        Intent intent = getIntent();
        message = intent.getStringExtra("DESTINATION_TO_VIEW");

        // Create the text view
        TextView textView = (TextView) findViewById(R.id.destinationName);
        textView.setText(message);

        //TODO Set destinationCode based on bucketlistdriver
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_destination_information, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete_bucketlist_item) {
            System.out.println("Bucket List Item Deleted");
            //TODO Delete "message" from bucketlist
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
