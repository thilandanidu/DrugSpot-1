package com.team35.drugspot;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {
    View view;
    public Holder(@NonNull View itemView) {
        super(itemView);

        view = itemView;
    }

    public void setView(Context context ,String date,String not,String notid){
        TextView date_tv = view.findViewById(R.id.date_tv);
        TextView not_tv = view.findViewById(R.id.not_tv);
        TextView notid_tv = view.findViewById(R.id.notid_tv);

        date_tv.setText(date);
        not_tv.setText(not);
        notid_tv.setText(notid);
    }
}
