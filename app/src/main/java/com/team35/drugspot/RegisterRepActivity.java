package com.team35.drugspot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class RegisterRepActivity extends AppCompatActivity {

    EditText fullName, nic, mobNum, email, password;

    Button registerUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_rep);
        getSupportActionBar().hide();

        fullName = findViewById(R.id.fullName);
        nic = findViewById(R.id.nic);
        mobNum = findViewById(R.id.mobNum);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        registerUser = findViewById(R.id.registerUser);
        reference = FirebaseDatabase.getInstance().getReference().child("representatives");

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertRepData();
                fullName.getText().clear();
                nic.getText().clear();
                mobNum.getText().clear();
                email.getText().clear();
                password.getText().clear();
            }
        });
    }

    private void insertRepData() {
        String RepFullName = fullName.getText().toString();
        String RepNic = nic.getText().toString();
        String RepNum = mobNum.getText().toString();
        String RepEmail = email.getText().toString();
        String RepPassword = password.getText().toString();

        Representative representative = new Representative(RepFullName, RepNic, RepNum, RepEmail, RepPassword);

        if (!representative.RepFullName.isEmpty() && !representative.RepNic.isEmpty() && !representative.RepNum.isEmpty()
                && !representative.RepEmail.isEmpty() && !representative.RepPassword.isEmpty()) {
            reference.push().setValue(representative);
            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            openRepLogin();
        } else {
            Toast.makeText(this, "Fill all Fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void openRepLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}