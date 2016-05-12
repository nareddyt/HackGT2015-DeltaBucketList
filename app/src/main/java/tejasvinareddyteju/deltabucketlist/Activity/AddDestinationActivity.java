package tejasvinareddyteju.deltabucketlist.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import tejasvinareddyteju.deltabucketlist.R;
import tejasvinareddyteju.deltabucketlist.Model.BucketList;
import tejasvinareddyteju.deltabucketlist.Model.Destination;
import tejasvinareddyteju.deltabucketlist.UI.SimpleDividerItemDecoration;

import java.util.Arrays;

public class AddDestinationActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static class RecyclerAdapter extends RecyclerView
            .Adapter<RecyclerAdapter.ViewHolder> {
        private Context m;
        private Destination[] sortedList;

        // Provide a suitable constructor (depends on the kind of dataset)
        public RecyclerAdapter(Context m) {
            this.m = m;
            sortedList = BucketList.getAllDestinations();
            Arrays.sort(sortedList, new Destination.NameComparator());
        }

        // Create new views (invoked by the layout manager)
        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R
                    .layout.recycleview_add_destination, parent, false);
            ViewHolder vh = new ViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int
                position) {
            holder.recyclerLocationCheckBox.setOnCheckedChangeListener(null);

            //FIXME updating this does not always get called
            if (BucketList.hasAllDestinationsChanged()) {
                System.out.println("All Destinations Changed!");
                sortedList = BucketList.getAllDestinations();
                Arrays.sort(sortedList, new Destination.NameComparator());
            }

            System.out.println("All Destinations = " + Arrays.deepToString
                    (sortedList));

            final Destination toAdd = sortedList[position];
            final String name = toAdd.getName();

            holder.recyclerLocationName.setText(name);
            holder.recyclerLocationCode.setText("Airport Code: " + toAdd
                    .getAirportCode());

            // FIXME image sizes too big and cause lag
            holder.recyclerLocationImage.setImageResource(toAdd.getImageId());

            if (BucketList.hasDestination(name)) {
                holder.recyclerLocationCheckBox.setChecked(true);
            } else {
                holder.recyclerLocationCheckBox.setChecked(false);
            }

            holder.recyclerLocationCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    if (isChecked) {
                        BucketList.addDestination(name);
                        System.out.println(name + " added!");
                    } else {
                        BucketList.removeDestination(name);
                        System.out.println(name + " removed!");
                    }
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
            public TextView recyclerLocationName;
            public TextView recyclerLocationCode;
            public ImageView recyclerLocationImage;
            public CheckBox recyclerLocationCheckBox;

            public ViewHolder(View view) {
                super(view);
                recyclerLocationName = (TextView) view.findViewById(R.id
                        .recyclerAddDestinationName);
                recyclerLocationCode = (TextView) view.findViewById(R.id
                        .recyclerAddDestinationCode);
                recyclerLocationImage = (ImageView) view.findViewById(R.id
                        .recyclerAddDestinationIcon);
                recyclerLocationCheckBox = (CheckBox) view.findViewById(R.id
                        .recyclerAddDestinationCheckBox);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_destination);
        mRecyclerView = (RecyclerView) findViewById(R.id
                .addLocationsRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Add dividers
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration
                (getApplicationContext()));

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
