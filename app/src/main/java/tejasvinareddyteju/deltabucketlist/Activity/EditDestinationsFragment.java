package tejasvinareddyteju.deltabucketlist.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import tejasvinareddyteju.deltabucketlist.R;
import tejasvinareddyteju.deltabucketlist.UI.EditDestinationsAdapter;
import tejasvinareddyteju.deltabucketlist.UI.SimpleDividerItemDecoration;

public class EditDestinationsFragment extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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
        mAdapter = new EditDestinationsAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
