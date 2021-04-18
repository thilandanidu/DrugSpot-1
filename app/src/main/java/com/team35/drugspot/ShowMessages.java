package com.team35.drugspot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowMessages extends AppCompatActivity {

    ListView myListView;
    List<Messages> messagesList;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_messages);

        myListView = findViewById(R.id.myListView);
        messagesList = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("msgs");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                messagesList.clear();

                for (DataSnapshot messageDataSnap : dataSnapshot.getChildren()){

                    Messages messages = messageDataSnap.getValue(Messages.class);
                    messagesList.add(messages);
                }

                ListAdapter adapter = new ListAdapter(ShowMessages.this,messagesList);
                myListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}