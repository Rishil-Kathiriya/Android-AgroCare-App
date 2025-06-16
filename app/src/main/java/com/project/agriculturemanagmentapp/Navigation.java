package com.project.agriculturemanagmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Navigation extends AppCompatActivity {
ImageView imgprfpc;
TextView txtuname,txtumo;
SharedPreferences sharedPreferences;
RelativeLayout rvlang,rvgv,rvrate,cous,rvshareapp,rvloout,rvtc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        txtumo=findViewById(R.id.txtumo);
        txtuname=findViewById(R.id.txtuname);
        imgprfpc=findViewById(R.id.imgprfpc);
        rvlang=findViewById(R.id.rvlang);
        rvgv=findViewById(R.id.rvgv);
        rvrate=findViewById(R.id.rvrate);
        cous=findViewById(R.id.cous);
        rvshareapp=findViewById(R.id.rvshareapp);
        rvloout=findViewById(R.id.rvloout);
        rvtc=findViewById(R.id.rvtc);
        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        Glide.with(this)
                .load(sharedPreferences.getString("url","null"))
                .circleCrop()
                .error(getDrawable(R.drawable.baseline_warning_24))
                .into(imgprfpc);
        txtuname.setText(sharedPreferences.getString("uname","null"));
        txtumo.setText("+91 "+sharedPreferences.getString("mo","null"));
        rvlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,Language.class));
                finish();
            }
        });
    }
}