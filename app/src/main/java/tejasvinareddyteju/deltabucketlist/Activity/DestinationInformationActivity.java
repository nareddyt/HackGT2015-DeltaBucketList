package tejasvinareddyteju.deltabucketlist.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import tejasvinareddyteju.deltabucketlist.Model.BucketList;
import tejasvinareddyteju.deltabucketlist.Model.Destination;
import tejasvinareddyteju.deltabucketlist.R;

public class DestinationInformationActivity extends AppCompatActivity {
    private String message_destName;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_information);

        Intent intent = getIntent();
        message_destName = intent.getStringExtra("DESTINATION_TO_VIEW");

        // Create the text view
        TextView textViewHead = (TextView) findViewById(R.id.destinationName);
        textViewHead.setText(message_destName);
        final Destination dest = BucketList.getDestination(message_destName);

        TextView textViewCode = (TextView) findViewById(R.id.destinationCode);
        textViewCode.setText(dest.getAirportCode());

        TextView textViewCost = (TextView) findViewById(R.id.destinationCost);
        textViewCost.setText("$" + dest.getBestCost());

        TextView textViewDate = (TextView) findViewById(R.id.destinationDate);
        textViewDate.setText(dest.getBestDateTime());

        ImageView imageView = (ImageView) findViewById(R.id.destinationImage);
        imageView.setImageResource(dest.getImageId());

        SeekBar priorityBar = (SeekBar) findViewById(R.id.destinationPriority);
        priorityBar.setMax(10);     // FIXME make a public static final variable
        priorityBar.setProgress(dest.getPriority());
        priorityBar.setOnSeekBarChangeListener(new SeekBar
                .OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue,
                                          boolean fromUser) {
                // FIXME bug not saving values
                dest.setPriority(progresValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });
    }
}
