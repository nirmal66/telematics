package com.hcl.developer.telematics.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hcl.developer.telematics.Adapter.OwnerHistoryAdapter;
import com.hcl.developer.telematics.MainActivity;
import com.hcl.developer.telematics.Model.RecentCarRequest;
import com.hcl.developer.telematics.R;
import com.hcl.developer.telematics.Utilities.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HistoryUserFragment extends BaseFragment
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<RecentCarRequest> recentLists = new ArrayList<>();
    private Button carRequest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_history_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preparenotificationData();
        mAdapter = new OwnerHistoryAdapter(recentLists);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view_app);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        carRequest = (Button)view.findViewById(R.id.carRequest);
        carRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).fragment(new MapFragment(),"Map Fragment");

            }
        });

    }
    private void preparenotificationData() {
        RecentCarRequest movie = new RecentCarRequest("Nirmal", "3 minutes ago","3","chennai","pondy");
        recentLists.add(movie);

        movie = new RecentCarRequest("Nirmal", "3 minutes ago","3","chennai","pondy");
        recentLists.add(movie);

    }

}
