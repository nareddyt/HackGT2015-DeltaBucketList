package tejasvinareddyteju.deltabucketlist.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import tejasvinareddyteju.deltabucketlist.Model.BucketList;
import tejasvinareddyteju.deltabucketlist.R;
import tejasvinareddyteju.deltabucketlist.UI.BucketListAdapter;

public class BucketListFragment extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //Called when the user presses the FAB
    public void addNewItem(View view) {
        Intent intent = new Intent(this, EditDestinationsFragment.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new BucketList();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id
                .bucketlistRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new BucketListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
