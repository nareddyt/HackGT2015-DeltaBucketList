package tejasvinareddyteju.deltabucketlist.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import tejasvinareddyteju.deltabucketlist.Model.BucketList;
import tejasvinareddyteju.deltabucketlist.R;
import tejasvinareddyteju.deltabucketlist.UI.BucketListAdapter;

public class BucketListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public BucketListFragment() {
        // Required empty constructor
    }

    public static BucketListFragment newInstance() {
        BucketListFragment fragment = new BucketListFragment();
        return fragment;
    }

    // FIXME fab button
    //Called when the user presses the FAB
//    public void addNewItem(View view) {
//        Intent intent = new Intent(this.getContext(),
// EditDestinationsFragment.class);
//        startActivity(intent);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new BucketList();
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_main,
                container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id
                .bucketlistRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // CHECKME use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new BucketListAdapter(this.getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
