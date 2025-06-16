package com.project.agriculturemanagmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import java.util.Locale;

public class Language extends AppCompatActivity {

    ToggleButton tgleng, tglhnd, tglgjr, tgltml, tglknd, tglurd, tgltlg, tglbgl, tglpjb, tglmlylm,tglmrt;
    ImageButton btnsublang;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.background));

        setLanguage();
        setContentView(R.layout.activity_language);
        btnsublang = findViewById(R.id.btnsublang);
        tgleng = findViewById(R.id.tgleng);
        tglhnd = findViewById(R.id.tglhnd);
        tglgjr = findViewById(R.id.tglgjr);
        tgltml = findViewById(R.id.tgltml);
        tglknd = findViewById(R.id.tglknd);
        tgltlg = findViewById(R.id.tgltlg);
        tglurd = findViewById(R.id.tglurd);
        tglbgl = findViewById(R.id.tglbgl);
        tglpjb = findViewById(R.id.tglpjb);
        tglmrt=findViewById(R.id.tglmrt);
        tglmlylm = findViewById(R.id.tglmlylm);
        btnsublang = findViewById(R.id.btnsublang);
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        sedit = sharedPreferences.edit();
        tgleng.setTextOn("English");
        tglhnd.setTextOn("हिन्दी");
        tglgjr.setTextOn("ગુજરાતી");
        tgltml.setTextOn("தமிழ்");
        tglknd.setTextOn("ಕನ್ನಡ");
        tglurd.setTextOn("اردو");
        tgltlg.setTextOn("తెలుగు");
        tglbgl.setTextOn("বাংলা");
        tglpjb.setTextOn("پَن٘جابی");
        tglmlylm.setTextOn("മലയാളം");
        tglmrt.setTextOn("Marathi");
        tgleng.setChecked(true);
        tgleng.setTextColor(getResources().getColor(R.color.Dark_green));
        btnsublang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgleng.isChecked()) {
                    sedit.putString("getlen", "en");
                }
                if (tglhnd.isChecked()) {
                    sedit.putString("getlen", "hi");
                }
                if (tglgjr.isChecked()) {
                    sedit.putString("getlen", "gu");
                }
                if (tglknd.isChecked()) {
                    sedit.putString("getlen", "kn");
                }
                if (tglmlylm.isChecked()) {
                    sedit.putString("getlen", "ml");
                }
                if (tglpjb.isChecked()) {
                    sedit.putString("getlen", "pa");
                }
                if (tgltml.isChecked()) {
                    sedit.putString("getlen", "ta");
                }
                if (tgltlg.isChecked()) {
                    sedit.putString("getlen", "te");
                }
                if (tglurd.isChecked()) {
                    sedit.putString("getlen", "ur");
                }
                if (tglbgl.isChecked()) {
                    sedit.putString("getlen", "bn");
                }
                if (tglmrt.isChecked()) {
                    sedit.putString("getlen", "mr");
                }
                sedit.apply();
                sedit.commit();
              //  startActivity(new Intent(Language.this, MainActivity.class));
            }
        });
        tgleng.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tgleng, true);
                } else {
                    selelang(tgleng, false);
                }
            }
        });
        tglhnd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tglhnd, true);
                } else {
                    selelang(tglhnd, false);
                }
            }
        });
        tglmrt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tglmrt, true);
                } else {
                    selelang(tglmrt, false);
                }
            }
        });
        tglgjr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tglgjr, true);
                } else {
                    selelang(tglgjr, false);
                }
            }
        });
        tgltml.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tgltml, true);
                } else {
                    selelang(tgltml, false);
                }
            }
        });
        tglknd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tglknd, true);
                } else {
                    selelang(tglknd, false);
                }
            }
        });
        tgltlg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tgltlg, true);
                } else {
                    selelang(tgltlg, false);
                }
            }
        });
        tglurd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tglurd, true);
                } else {
                    selelang(tglurd, false);
                }
            }
        });
        tglbgl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tglbgl, true);
                } else {
                    selelang(tglbgl, false);
                }
            }
        });
        tglpjb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tglpjb, true);
                } else {
                    selelang(tglpjb, false);
                }
            }
        });
        tglmlylm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selelang(tglmlylm, true);
                } else {
                    selelang(tglmlylm, false);
                }
            }
        });
    }

    public void selelang(ToggleButton toggleButton, Boolean isChecked) {
        if (isChecked) {
            int red = getResources().getColor(R.color.Dark_red);
            int green = getResources().getColor(R.color.Dark_green);
            tgleng.setChecked(false);
            tgleng.setTextColor(red);
            tglhnd.setChecked(false);
            tglhnd.setTextColor(red);
            tglgjr.setChecked(false);
            tglgjr.setTextColor(red);
            tgltml.setChecked(false);
            tgltml.setTextColor(red);
            tglknd.setChecked(false);
            tglknd.setTextColor(red);
            tglurd.setChecked(false);
            tglurd.setTextColor(red);
            tgltlg.setChecked(false);
            tgltlg.setTextColor(red);
            tglbgl.setChecked(false);
            tglbgl.setTextColor(red);
            tglpjb.setChecked(false);
            tglpjb.setTextColor(red);
            tglmlylm.setChecked(false);
            tglmlylm.setTextColor(red);
            tglmrt.setChecked(false);
            tglmrt.setTextColor(red);
            toggleButton.setTextColor(green);
            toggleButton.setChecked(true);
        } else {
            int red = getResources().getColor(R.color.Dark_red);
            tgleng.setChecked(false);
            tgleng.setTextColor(red);
            tglhnd.setChecked(false);
            tglhnd.setTextColor(red);
            tglgjr.setChecked(false);
            tglgjr.setTextColor(red);
            tgltml.setChecked(false);
            tgltml.setTextColor(red);
            tglknd.setChecked(false);
            tglknd.setTextColor(red);
            tglurd.setChecked(false);
            tglurd.setTextColor(red);
            tgltlg.setChecked(false);
            tgltlg.setTextColor(red);
            tglbgl.setChecked(false);
            tglbgl.setTextColor(red);
            tglpjb.setChecked(false);
            tglpjb.setTextColor(red);
            tglmrt.setChecked(false);
            tglmrt.setTextColor(red);
            tglmlylm.setChecked(false);
            tglmlylm.setTextColor(red);
        }
    }

    public void setLanguage() {
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor sedit = sharedPreferences.edit();
        String lang = sharedPreferences.getString("getlen", "");
        Locale locale = new Locale(lang, "rnIN");
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

}