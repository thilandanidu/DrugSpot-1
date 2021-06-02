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
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {


    Button btnInsertData,pastOrders,notification;
    DatabaseReference orderDbRef;
    Spinner processing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        final EditText phAddress = findViewById(R.id.phAddress);
        final EditText phEmail = findViewById(R.id.phEmail);
        final EditText phName = findViewById(R.id.phName);
        final EditText phNum = findViewById(R.id.phNum);
        final EditText phOrder = findViewById(R.id.phOrder);
        btnInsertData = findViewById(R.id.btnInsertData);
        pastOrders = findViewById(R.id.pastOrders);
        notification = findViewById(R.id.notification);
        processing = findViewById(R.id.processing);

        DAOOrder dao = new DAOOrder();

        btnInsertData.setOnClickListener(v->
        {
            Order odr = new Order(phAddress.getText().toString(),phEmail.getText().toString(),phName.getText().toString()
                    ,phNum.getText().toString(),phOrder.getText().toString(),processing.getSelectedItem().toString());
            dao.add(odr).addOnSuccessListener(suc->
            {
                Toast.makeText(this,"Order Inserted",Toast.LENGTH_SHORT).show();
                phAddress.getText().clear();
                phEmail.getText().clear();
                phName.getText().clear();
                phNum.getText().clear();
                phOrder.getText().clear();
        }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification();
            }
        });
    }

    /*private void insertOrderData() {
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
    }*/

    private void Notification() {
        Intent intent = new Intent(this, MessagesActivity.class);
        startActivity(intent);
    }
}