package com.project.agriculturemanagmentapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Myfeed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Myfeed extends Fragment {
    RcFeedAdapter rcFeedAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Myfeed() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Myfeed.
     */
    // TODO: Rename and change types and number of parameters
    public static Myfeed newInstance(String param1, String param2) {
        Myfeed fragment = new Myfeed();
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
        View view= inflater.inflate(R.layout.fragment_myfeed, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.rcmyfeed);
        FloatingActionButton addfeed=view.findViewById(R.id.addfeed);
        SharedPreferences sharedPreferences= getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        String mo=sharedPreferences.getString("mo","123456789");
        FirebaseRecyclerOptions<clsFeedModel> options=new FirebaseRecyclerOptions.Builder<clsFeedModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("User").child(mo).child("Feed"), clsFeedModel.class)
                .build();
        rcFeedAdapter=new RcFeedAdapter(options,getContext(),true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(rcFeedAdapter);
        addfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),add_feed.class));
            }
        });
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