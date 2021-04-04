package com.team35.drugspot;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Button btnInsertData;
    DatabaseReference orderDbRef;
    EditText phAddress;
    EditText phEmail;
    EditText phName;
    EditText phNum;
    EditText phOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phAddress = findViewById(R.id.phAddress);
        phEmail = findViewById(R.id.phEmail);
        phName = findViewById(R.id.phName);
        phNum = findViewById(R.id.phNum);
        phOrder = findViewById(R.id.phOrder);
        btnInsertData = findViewById(R.id.btnInsertData);

        orderDbRef = FirebaseDatabase.getInstance().getReference().child("Order");

        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertOrderData();
                phAddress.getText().clear();
                phEmail.getText().clear();
                phName.getText().clear();
                phNum.getText().clear();
                phOrder.getText().clear();
            }
        });
    }

    private void insertOrderData() {
        String phmAddress = phAddress.getText().toString();
        String phmEmail = phEmail.getText().toString();
        String phmName = phName.getText().toString();
        String phmNum = phNum.getText().toString();
        String phmOrder = phOrder.getText().toString();

        Order order = new Order(phmAddress,phmEmail,phmName,phmNum,phmOrder);

        if (!order.phmAddress.isEmpty() && !order.phmEmail.isEmpty() && !order.phmName.isEmpty()
                && !order.phmNum.isEmpty() && !order.phmOrder.isEmpty()) {
            orderDbRef.push().setValue(order);
            Toast.makeText(this, "Order Added",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Fill all Fields",Toast.LENGTH_SHORT).show();
    }
    }
}