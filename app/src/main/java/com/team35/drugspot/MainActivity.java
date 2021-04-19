package com.team35.drugspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Button btnInsertData,pastOrders,notification;
    DatabaseReference orderDbRef;
    EditText phAddress;
    EditText phEmail;
    EditText phName;
    EditText phNum;
    EditText phOrder;
    Spinner processing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        phAddress = findViewById(R.id.phAddress);
        phEmail = findViewById(R.id.phEmail);
        phName = findViewById(R.id.phName);
        phNum = findViewById(R.id.phNum);
        phOrder = findViewById(R.id.phOrder);
        btnInsertData = findViewById(R.id.btnInsertData);
        pastOrders = findViewById(R.id.pastOrders);
        notification = findViewById(R.id.notification);
        processing = findViewById(R.id.processing);

        orderDbRef = FirebaseDatabase.getInstance().getReference().child("Order");

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification();
            }
        });

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
        String ordStatus = processing.getSelectedItem().toString();

        Order order = new Order(phmAddress,phmEmail,phmName,phmNum,phmOrder,ordStatus);

        if (!order.phmAddress.isEmpty() && !order.phmEmail.isEmpty() && !order.phmName.isEmpty()
                && !order.phmNum.isEmpty() && !order.phmOrder.isEmpty()) {
            orderDbRef.push().setValue(order);
            Toast.makeText(this, "Order Added",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Fill all Fields",Toast.LENGTH_SHORT).show();
    }
    }

    private void Notification() {
        Intent intent = new Intent(this, MessagesActivity.class);
        startActivity(intent);
    }
}