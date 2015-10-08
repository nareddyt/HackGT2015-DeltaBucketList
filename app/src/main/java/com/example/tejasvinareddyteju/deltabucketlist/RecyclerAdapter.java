package com.example.tejasvinareddyteju.deltabucketlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Tejasvi on 10/7/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private BucketListDriver bucketListDriver = MainActivity.bucketListDriver;
    private Context m;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerAdapter(Context m) {
        this.m = m;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_add_destination, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Destination toAdd = bucketListDriver.possibleDestinationsToArray()[position];

        holder.recyclerLocationName.setText(toAdd.getName());
        holder.recyclerLocationCode.setText("Airport Code: " + toAdd.getAirportCode());
        holder.recyclerLocationImage.setImageResource(toAdd.getImageId());

        /*
        holder.recyclerLocationName.setTag(holder);
        holder.recyclerLocationName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewHolder holder = (ViewHolder) view.getTag();
                int position = holder.getPosition();
                Toast.makeText(m, "Added destination: " + position, Toast.LENGTH_SHORT).show();
            }
        });
        */
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return bucketListDriver.possibleDestinationsToArray().length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView recyclerLocationName;
        public TextView recyclerLocationCode;
        public ImageView recyclerLocationImage;
        public Switch recyclerLocationSwitch;

        public ViewHolder(View view) {
            super(view);
            //FIXME
            recyclerLocationName = (TextView) view.findViewById(R.id.recyclerDestinationName);
            recyclerLocationCode = (TextView) view.findViewById(R.id.recyclerDestinationCode);
            recyclerLocationImage = (ImageView) view.findViewById(R.id.recyclerDestinationIcon);
            recyclerLocationSwitch = (Switch) view.findViewById(R.id.recyclerDestinationSwitch);
        }
    }
}