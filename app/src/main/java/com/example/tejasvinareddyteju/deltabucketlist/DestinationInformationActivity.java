package com.example.tejasvinareddyteju.deltabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DestinationInformationActivity extends Activity {
    private String message_destName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_information);

        Intent intent = getIntent();
        message_destName = intent.getStringExtra("DESTINATION_TO_VIEW");

        // Create the text view
        TextView textViewHead = (TextView) findViewById(R.id.destinationName);
        textViewHead.setText(message_destName);
        Destination dest = BucketList.getDestination(message_destName);

        TextView textViewCode = (TextView) findViewById(R.id.destinationCode);
        textViewCode.setText(dest.getAirportCode());

        TextView textViewCost = (TextView) findViewById(R.id.destinationCost);
        textViewCost.setText("$" + dest.getBestCost());

        TextView textViewDate = (TextView) findViewById(R.id.destinationDate);
        textViewDate.setText(dest.getBestDateTime());

        ImageView imageView = (ImageView) findViewById(R.id.destinationImage);
        imageView.setImageResource(dest.getImageId());
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
            System.out.println(message_destName + " deleted");
            BucketList.removeDestination(message_destName);

            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
