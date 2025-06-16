package com.project.agriculturemanagmentapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class VpAdapterLabour extends FragmentPagerAdapter {
    Context context;
    public VpAdapterLabour(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Labour_Vacancy();
        }
        else{
            return new Labour_Management();
        }
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return context.getResources().getString(R.string.Labour_Vacancy);
        }
        else{
            return context.getResources().getString(R.string.Labour_Managment);
        }
    }
}
