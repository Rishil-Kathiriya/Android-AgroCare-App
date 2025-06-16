package com.project.agriculturemanagmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Optional;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShowFeed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowFeed extends Fragment {
    RcFeedAdapter rcFeedAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShowFeed() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShowFeed.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowFeed newInstance(String param1, String param2) {
        ShowFeed fragment = new ShowFeed();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_show_feed, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.rcviewshfeed);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        FirebaseRecyclerOptions<clsFeedModel> options=new FirebaseRecyclerOptions.Builder<clsFeedModel>()
                .setQuery(firebaseDatabase.getReference().child("Feed"), clsFeedModel.class)
                .build();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
         rcFeedAdapter =new RcFeedAdapter(options,getContext(),false);
        recyclerView.setAdapter(rcFeedAdapter);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
       rcFeedAdapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity

    @Override
    public void onDestroy() {
        super.onDestroy();
        rcFeedAdapter.stopListening();
    }
}