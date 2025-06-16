package com.project.agriculturemanagmentapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RcLabourAdapter extends FirebaseRecyclerAdapter<clsLaborModel,RcLabourAdapter.ViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    Context context;
    public RcLabourAdapter(@NonNull FirebaseRecyclerOptions<clsLaborModel> options,Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull RcLabourAdapter.ViewHolder holder, int position, @NonNull clsLaborModel model) {
        holder.txtlname.setText(model.getLname());
        holder.txtlmo.setText(model.getLmo());
        holder.txtlloc.setText(model.getLloc());
        holder.txtldec.setText(model.getLdes());
        holder.txtldate.setText(model.getLdate());
        holder.txtlwages.setText("$ "+model.getLwages());
        holder.rv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alert= new AlertDialog.Builder(context);
                AlertDialog deletebox=alert.create();
                alert.setIcon(context.getDrawable(R.drawable.baseline_warning_24));
                alert.setTitle(context.getString(R.string.Delete_data));
                alert.setMessage(context.getResources().getString(R.string.msgdlt));
                alert.setPositiveButton(context.getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sharedPreferences=context.getSharedPreferences("data", Context.MODE_PRIVATE);
                        String msg=context.getResources().getString(R.string.msg2)+" "+model.getLdate()+" "+context.getResources().getString(R.string.msg3);
                        FirebaseDatabase.getInstance().getReference().child("Labor_data").child(sharedPreferences.getString("mo","1234567890")).child(model.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                SmsManager smsManager = SmsManager.getDefault();
                                smsManager.sendTextMessage(model.getLmo(),null,msg,null,null);
                                deletebox.dismiss();
                            }
                        });
                    }
                });
                alert.setNegativeButton(context.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deletebox.dismiss();
                    }
                });
                alert.show();
                return false;
            }
        });
    }

    @NonNull
    @Override
    public RcLabourAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lytlabor,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtlname,txtlmo,txtlloc,txtldec,txtldate,txtlwages;
        RelativeLayout rv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtlname=itemView.findViewById(R.id.txtlname);
            txtlmo=itemView.findViewById(R.id.txtmo);
            txtlloc=itemView.findViewById(R.id.txtlo);
            txtldec=itemView.findViewById(R.id.txtdes);
            txtldate=itemView.findViewById(R.id.txtdate);
            txtlwages=itemView.findViewById(R.id.txtWages);
            rv=itemView.findViewById(R.id.rv);
        }
    }
}
