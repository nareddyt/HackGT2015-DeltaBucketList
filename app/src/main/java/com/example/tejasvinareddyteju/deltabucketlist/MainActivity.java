package com.example.tejasvinareddyteju.deltabucketlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new BucketList();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.bucketlistRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
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

    //Called when the user presses the FAB
    public void addNewItem(View view) {
        Intent intent = new Intent(this, AddDestinationActivity.class);
        startActivity(intent);
    }

    public static class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
        private Context m;
        private List<Destination> sortedList;

        // Provide a suitable constructor (depends on the kind of dataset)
        public RecyclerAdapter(Context m) {
            this.m = m;
            sortedList = BucketList.getAddedDestinations();
            Collections.sort(sortedList, new Destination.PriorityComparator());
        }

        // Create new views (invoked by the layout manager)
        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_main_bucketlist, parent, false);
            ViewHolder vh = new ViewHolder(view);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.destinationIcon.setOnClickListener(null);

            if (BucketList.hasAddedDestinationsChanged()) {
                System.out.println("Added destinations changed!");
                sortedList = BucketList.getAddedDestinations();
                Collections.sort(sortedList, new Destination.PriorityComparator());
            }
            final Destination toAdd = sortedList.get(position);
            final String name = toAdd.getName();

            holder.destinationIcon.setImageResource(toAdd.getImageId());
            holder.destinationName.setText(name);

            Bitmap bitmap = BitmapFactory.decodeResource(m.getResources(), toAdd.getImageId());
            Palette palette = Palette.generate(bitmap);

            Palette.Swatch swatch = palette.getVibrantSwatch();
            int backgroundColor = swatch.getRgb();
            holder.destinationName.setBackgroundColor(backgroundColor);
            holder.destinationName.getBackground().setAlpha(175);
            holder.destinationName.setTextColor(Color.WHITE);

            holder.destinationIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    Intent intent = new Intent(m, DestinationInformationActivity.class);
                    intent.putExtra("DESTINATION_TO_VIEW", name);
                    m.startActivity(intent);
                }
            });
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return sortedList.size();
        }

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView destinationIcon;
            public TextView destinationName;

            public ViewHolder(View view) {
                super(view);
                destinationIcon = (ImageView) view.findViewById(R.id.recyclerMainIcon);
                destinationName = (TextView) view.findViewById(R.id.recyclerMainName);
            }
        }
    }
}
