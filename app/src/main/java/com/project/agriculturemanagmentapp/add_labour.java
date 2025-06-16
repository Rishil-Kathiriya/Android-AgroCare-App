package com.project.agriculturemanagmentapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;
import java.util.Stack;

public class add_labour extends AppCompatActivity {
TextInputEditText edtlname,edtlmo,edtlplace,edtlwages,edtldes;
ImageView imageView;
RelativeLayout rldate,submit;
TextView date;
SharedPreferences sharedPreferences;
boolean isDateSelected=false;

    ProgressBar progressBar;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_labour);
        edtlname=findViewById(R.id.edtlname);
        edtlmo=findViewById(R.id.edtlmo);
        edtlplace=findViewById(R.id.edtlplace);
        txt=findViewById(R.id.txt);
        edtlwages=findViewById(R.id.edtlwages);
        edtldes=findViewById(R.id.edtldes);
        progressBar=findViewById(R.id.progressBar2);
        rldate=findViewById(R.id.rldate);
        submit=findViewById(R.id.btnsavedetail);
        date=findViewById(R.id.txtdate);
        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        rldate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(add_labour.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month++;
                        date.setText(dayOfMonth+"/"+month+"/"+year);
                        isDateSelected=true;

                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtlname.getText().toString().trim().isEmpty()){
                    edtlname.setError(getResources().getString(R.string.Required_Field));
                } else if (edtlmo.getText().toString().trim().isEmpty()) {
                    edtlmo.setError(getResources().getString(R.string.Required_Field));
                } else if (edtlmo.getText().toString().trim().length()!=10) {
                    edtlmo.setError(getResources().getString(R.string.Invalid_MobileNumber));
                } else if (edtlwages.getText().toString().trim().isEmpty()) {
                    edtlwages.setError(getResources().getString(R.string.Required_Field));
                }else if (isDateSelected==false){
                    Toast.makeText(add_labour.this, getResources().getString(R.string.Select_date), Toast.LENGTH_SHORT).show();
                }
                else{
                    submit.setEnabled(false);
                    submit.setClickable(false);
                    progressBar.setVisibility(View.VISIBLE);
                    txt.setVisibility(View.GONE);
                    String key= FirebaseDatabase.getInstance().getReference().child("Labor_data").child(sharedPreferences.getString("mo","1234567890")).push().getKey();
                    FirebaseDatabase.getInstance().getReference().child("Labor_data").child(sharedPreferences.getString("mo","1234567890")).child(key).setValue(
                            new clsLaborModel(
                                    edtlname.getText().toString(),
                                    edtlmo.getText().toString(),
                                    edtlplace.getText().toString(),
                                    edtlwages.getText().toString(),
                                    edtldes.getText().toString(),
                                    date.getText().toString(),
                                    key
                            )).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            progressBar.setVisibility(View.GONE);
                            txt.setVisibility(View.VISIBLE);
                            String msg= getResources().getString(R.string.Hello)+" "+edtlname.getText().toString()+" ,\n"+getResources().getString(R.string.msg1)+"\n"+
                                    getResources().getString(R.string.Worker_name)+" : "+edtlname.getText().toString()+"\n"+
                                    getResources().getString(R.string.loc)+" : "+edtlplace.getText().toString()+"\n"+
                                    getResources().getString(R.string.date)+" : "+date.getText().toString()+"\n"+
                                    getResources().getString(R.string.Wages)+" : "+edtlwages.getText().toString()+"\n"+
                                    getResources().getString(R.string.Sender)+" : "+sharedPreferences.getString("uname","unknown");
                            SmsManager smsManager= SmsManager.getDefault();
                            smsManager.sendTextMessage(edtlmo.getText().toString(),null,msg,null,null);
                            Toast.makeText(add_labour.this, getResources().getString(R.string.Data_Added_Sucessfully), Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                }
                }

        });
    }
}