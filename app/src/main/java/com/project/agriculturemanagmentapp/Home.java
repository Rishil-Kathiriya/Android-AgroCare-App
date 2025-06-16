package com.project.agriculturemanagmentapp;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class Home extends AppCompatActivity {
MeowBottomNavigation btmnv;
FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btmnv=findViewById(R.id.btmnv);
        frameLayout =findViewById(R.id.fmlayout);
        btmnv.show(3,true);
        btmnv.add(new MeowBottomNavigation.Model(1, R.drawable.feed2));
        btmnv.add(new MeowBottomNavigation.Model(2, R.drawable.labour));
        btmnv.add(new MeowBottomNavigation.Model(3,R.drawable.house));
        btmnv.add(new MeowBottomNavigation.Model(4,R.drawable.baseline_sell_24));
        btmnv.add(new MeowBottomNavigation.Model(5,R.drawable.online_store));
        btmnv.add(new MeowBottomNavigation.Model(6,R.drawable.baseline_account_circle_24));
        btmnv.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
    @Override
    public Unit invoke(MeowBottomNavigation.Model model) {
        if(model.getId()==1){
            frameLayout.removeAllViews();
            getSupportFragmentManager().beginTransaction().add(R.id.fmlayout,new Feed()).commit();
        } else if (model.getId()==2) {
            frameLayout.removeAllViews();
            getSupportFragmentManager().beginTransaction().add(R.id.fmlayout,new Labour()).commit();
        } else if (model.getId()==6) {
            startActivity(new Intent(Home.this, Navigation.class));
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        } else {
            frameLayout.removeAllViews();
        }
        return null;
    }
});
    }

    @Override
    protected void onStart() {
        super.onStart();
        btmnv.show(3,true);
    }
}