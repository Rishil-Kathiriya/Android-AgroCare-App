package com.project.agriculturemanagmentapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class Feed extends Fragment {

    Context context;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Feed() {
        // Required empty public constructor
    }
    public Feed(Context context) {
        this.context=context;
    }
    public static Feed newInstance(String param1, String param2) {
        Feed fragment = new Feed();
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
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        ViewPager viewPager=view.findViewById(R.id.vpfeed);
        TabLayout tabLayout=view.findViewById(R.id.tbllytfeed);
        VpAdapterFeed vpAdapterFeed=new VpAdapterFeed(getChildFragmentManager(),getContext());
        viewPager.setAdapter(vpAdapterFeed);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}