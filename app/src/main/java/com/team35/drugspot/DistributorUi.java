package com.team35.drugspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DistributorUi extends AppCompatActivity {
    private Button odrPending,itemList,notifications,itemList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_distributor_ui);

        odrPending = (Button) findViewById(R.id.odrPending);
        itemList = (Button) findViewById(R.id.itemList);
        notifications = (Button) findViewById(R.id.notifications);

        odrPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openOdrPending();
            }
        });

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openNotifications();
            }
        });

        itemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openItemList();
            }
        });

        itemList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openItemList1();
            }
        });
    }

    private void openOdrPending() {
        Intent intent = new Intent(this, RVActivity.class);
        startActivity(intent);
    }

    private void openItemList() {
        Intent intent = new Intent(this, OrderState.class);
        startActivity(intent);
    }

    private void openNotifications() {
        Intent intent = new Intent(this, MessagesActivity.class);
        startActivity(intent);
    }

    private void openItemList1() {
        Intent intent = new Intent(this, MessagesActivity.class);
        startActivity(intent);
    }
}