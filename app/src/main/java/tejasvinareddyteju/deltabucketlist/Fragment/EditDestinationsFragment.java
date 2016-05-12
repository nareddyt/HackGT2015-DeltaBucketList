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
import tejasvinareddyteju.deltabucketlist.UI.EditDestinationsAdapter;
import tejasvinareddyteju.deltabucketlist.UI.SimpleDividerItemDecoration;

public class EditDestinationsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public EditDestinationsFragment() {
        // Required empty constructor
    }

    public static EditDestinationsFragment newInstance() {
        EditDestinationsFragment fragment = new EditDestinationsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new BucketList();
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_edit_destinations,
                container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id
                .addLocationsRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // CHECKME use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Add dividers
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                this.getContext()));

        // specify an adapter (see also next example)
        mAdapter = new EditDestinationsAdapter(this.getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
