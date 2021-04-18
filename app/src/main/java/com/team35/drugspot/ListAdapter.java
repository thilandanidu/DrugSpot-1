package com.team35.drugspot;

import android.app.Activity;
import android.app.Notification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Messages> messagesList;

    public ListAdapter(Activity mContext, List<Messages> messagesList){
        super(mContext,R.layout.list_messages,messagesList);
        this.mContext = mContext;
        this.messagesList = messagesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = mContext.getLayoutInflater();
        View listMessageView = inflater.inflate(R.layout.list_messages,null,true);

        TextView noteID = listMessageView.findViewById(R.id.noteID);
        TextView date = listMessageView.findViewById(R.id.date);
        TextView note = listMessageView.findViewById(R.id.note);

        Messages messages = messagesList.get(position);

        noteID.setText(messages.getNoteID());
        date.setText(messages.getDate());
        note.setText(messages.getNote());

        return listMessageView;
    }
}
