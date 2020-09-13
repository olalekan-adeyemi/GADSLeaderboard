package com.lakeside.gadsleaderboard.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lakeside.gadsleaderboard.R;
import com.lakeside.gadsleaderboard.ui.adapter.LeaderBoardAdapter;
import com.lakeside.gadsleaderboard.ui.model.Leader;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class SectionFragment extends Fragment {

    private static final String TAG = "SectionFragment";
    private static final String ARG_SECTION_NUMBER = "section_number";

    private LeaderBoardViewModel viewModel;
    private int mIndex;
    private ProgressBar progress;
    private RecyclerView recyclerView;
    private LeaderBoardAdapter adapter;

    public static SectionFragment newInstance(int index) {
        SectionFragment fragment = new SectionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LeaderBoardViewModel.class);

        mIndex = 0;
        if (getArguments() != null) {
            mIndex = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        //viewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_leader_board, container, false);

        //Setting the views
        recyclerView = root.findViewById(R.id.recyclerView);
        progress = root.findViewById(R.id.progress);
        progress.setVisibility(View.VISIBLE);
        adapter = new LeaderBoardAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        if(mIndex == 0) {

            viewModel.getHours().observe(getViewLifecycleOwner(), leaders -> {
                //Log.d(TAG, "onChange, Section to query is learning leaders " + leaders);
                adapter.setLeaders(leaders);
                progress.setVisibility(View.INVISIBLE);
            });

        }else {

            viewModel.getSkillIQ().observe(getViewLifecycleOwner(), leaders -> {
                //Log.d(TAG, "onChange, Section to query is skillIQ leader " + leaders);
                adapter.setLeaders(leaders);
                progress.setVisibility(View.INVISIBLE);
            });
        }


        return root;
    }
}