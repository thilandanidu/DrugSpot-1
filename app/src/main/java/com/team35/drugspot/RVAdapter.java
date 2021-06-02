package com.team35.drugspot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<Order> list = new ArrayList<>();

    public RVAdapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Order> odr)
    {
        list.addAll(odr);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new OrderVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        OrderVH vh = (OrderVH) holder;
        Order odr = list.get(position);
        vh.phm_name.setText(odr.getPhmName());
        vh.phm_num.setText(odr.getPhmNum());
        vh.phm_address.setText(odr.getPhmAddress());
        vh.phm_order.setText(odr.getPhmOrder());
        vh.phm_email.setText(odr.getPhmEmail());
        vh.phm_process.setText(odr.getOrdStatus());//no probs

    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
