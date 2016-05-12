package tejasvinareddyteju.deltabucketlist.UI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import tejasvinareddyteju.deltabucketlist.Activity
        .DestinationInformationActivity;
import tejasvinareddyteju.deltabucketlist.Model.BucketList;
import tejasvinareddyteju.deltabucketlist.Model.Destination;
import tejasvinareddyteju.deltabucketlist.R;

import java.util.Arrays;

public class BucketListAdapter extends RecyclerView
        .Adapter<BucketListAdapter.ViewHolder> {
    private Context m;
    private Destination[] sortedList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public BucketListAdapter(Context m) {
        this.m = m;
        sortedList = BucketList.getAddedDestinations();
        Arrays.sort(sortedList, new Destination.PriorityComparator());
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BucketListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R
                .layout.recycleview_main_bucketlist, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.destinationIcon.setOnClickListener(null);

        //FIXME updating this does not always get called
        if (BucketList.hasAddedDestinationsChanged()) {
            System.out.println("Added destinations changed!");
            sortedList = BucketList.getAddedDestinations();
            Arrays.sort(sortedList, new Destination.PriorityComparator());
        }

        System.out.println("Added Destinations = " + Arrays.deepToString
                (sortedList));

        final Destination toAdd = sortedList[position];
        final String name = toAdd.getName();

        holder.destinationIcon.setImageResource(toAdd.getImageId());
        holder.destinationName.setText(name);

        // FIXME determine Palette color beforehand to prevent lagging
        Bitmap bitmap = BitmapFactory.decodeResource(m.getResources(),
                toAdd.getImageId());
        Palette palette = Palette.generate(bitmap);

        Palette.Swatch swatch = palette.getVibrantSwatch();
        int backgroundColor = swatch.getRgb();
        holder.destinationName.setBackgroundColor(backgroundColor);
        holder.destinationName.getBackground().setAlpha(175);
        holder.destinationName.setTextColor(Color.WHITE);

        holder.destinationIcon.setOnClickListener(new View
                .OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(m,
                        DestinationInformationActivity.class);
                intent.putExtra("DESTINATION_TO_VIEW", name);
                m.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return sortedList.length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView destinationIcon;
        public TextView destinationName;

        public ViewHolder(View view) {
            super(view);
            destinationIcon = (ImageView) view.findViewById(R.id
                    .recyclerMainIcon);
            destinationName = (TextView) view.findViewById(R.id
                    .recyclerMainName);
        }
    }
}
