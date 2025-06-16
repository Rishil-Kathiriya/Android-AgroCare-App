package com.project.agriculturemanagmentapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Labour_Management#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Labour_Management extends Fragment {
RcLabourAdapter rcLabourAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Labour_Management() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Labour_Management.
     */
    // TODO: Rename and change types and number of parameters
    public static Labour_Management newInstance(String param1, String param2) {
        Labour_Management fragment = new Labour_Management();
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
        View view= inflater.inflate(R.layout.fragment_labour__management, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.rc);
        ExtendedFloatingActionButton btnAddWorker = view.findViewById(R.id.addlabor);
        SharedPreferences sharedPreferences=getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        FirebaseRecyclerOptions<clsLaborModel> options= new FirebaseRecyclerOptions.Builder<clsLaborModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Labor_data").child(sharedPreferences.getString("mo","1234567890")), clsLaborModel.class)
                .build();
        rcLabourAdapter=new RcLabourAdapter(options,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(rcLabourAdapter);
        btnAddWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), add_labour.class));
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        rcLabourAdapter.stopListening();
    }

    @Override
    public void onStart() {
        super.onStart();
        rcLabourAdapter.startListening();
    }
}