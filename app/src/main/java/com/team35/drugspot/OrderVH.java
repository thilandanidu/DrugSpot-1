package com.team35.drugspot;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderVH extends RecyclerView.ViewHolder
{
    public TextView phm_name,phm_num,phm_address,phm_order,phm_email,phm_process;
    public OrderVH(@NonNull View itemView)
    {
        super(itemView);
        phm_name = itemView.findViewById(R.id.phm_name);
        phm_num = itemView.findViewById(R.id.phm_num);
        phm_address = itemView.findViewById(R.id.phm_address);
        phm_order = itemView.findViewById(R.id.phm_order);
        phm_email = itemView.findViewById(R.id.phm_email);
        phm_process = itemView.findViewById(R.id.phm_process);//all right
    }
}
