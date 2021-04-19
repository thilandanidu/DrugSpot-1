package com.team35.drugspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterDisActivity extends AppCompatActivity {

    EditText fullName, nic, mobNum, email, password;

    Button registerUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_dis);
        getSupportActionBar().hide();

        fullName = findViewById(R.id.fullName);
        nic = findViewById(R.id.nic);
        mobNum = findViewById(R.id.mobNum);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        registerUser = findViewById(R.id.registerUser);
        reference = FirebaseDatabase.getInstance().getReference().child("distributors");

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDisData();
                fullName.getText().clear();
                nic.getText().clear();
                mobNum.getText().clear();
                email.getText().clear();
                password.getText().clear();
            }
        });
    }

    private void insertDisData() {
        String DisFullName = fullName.getText().toString();
        String DisNic = nic.getText().toString();
        String DisNum = mobNum.getText().toString();
        String DisEmail = email.getText().toString();
        String DisPassword = password.getText().toString();

        Distributor distributor = new Distributor(DisFullName, DisNic, DisNum, DisEmail, DisPassword);

        if (!distributor.DisFullName.isEmpty() && !distributor.DisNic.isEmpty() && !distributor.DisNum.isEmpty()
                && !distributor.DisEmail.isEmpty() && !distributor.DisPassword.isEmpty()) {
            reference.push().setValue(distributor);
            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            openDisLogin();
        } else {
            Toast.makeText(this, "Fill all Fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void openDisLogin() {
        Intent intent = new Intent(this, DistributorLoginActivity.class);
        startActivity(intent);
    }
}