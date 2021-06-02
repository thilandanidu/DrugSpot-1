package com.team35.drugspot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderState extends AppCompatActivity {
    Button submit;
    EditText ph_email;
    Spinner processing;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_order_state);
        submit = findViewById(R.id.submit);
        ph_email = findViewById(R.id.ph_email);
        processing = findViewById(R.id.processing1);
        reference = FirebaseDatabase.getInstance().getReference().child("OrderState");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateData();
                ph_email.getText().clear();
            }
        });
    }

    private void UpdateData() {
        String phr_email = ph_email.getText().toString();
        String spinner = processing.getSelectedItem().toString();

        OrderStateClass orderStateClass = new OrderStateClass(phr_email, spinner);

        if (!orderStateClass.phr_email.isEmpty() && !orderStateClass.spinner.isEmpty()){
            reference.push().setValue(orderStateClass);
            Toast.makeText(this, "Order State Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fill all Fields", Toast.LENGTH_SHORT).show();
        }
    }
}