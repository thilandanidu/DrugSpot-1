package com.team35.drugspot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MessagesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("msgs");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Messages> options =//change this to message if error
                new FirebaseRecyclerOptions.Builder<Messages>()
                .setQuery(reference,Messages.class)
                .build();

        FirebaseRecyclerAdapter<Messages,Holder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Messages, Holder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull Holder holder, int position, @NonNull Messages model) {
                        holder.setView(getApplication(),model.getDate(),model.getNot(),model.getNotid());

                    }

                    @NonNull
                    @Override
                    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.data,parent,false);//can cause issues

                        return new Holder(view);
                    }
                };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}