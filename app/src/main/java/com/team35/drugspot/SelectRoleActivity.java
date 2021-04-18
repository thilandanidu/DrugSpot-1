package com.team35.drugspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectRoleActivity extends AppCompatActivity {
    private Button rep;
    private Button dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_role);

        rep = (Button) findViewById(R.id.logRep);
        dis = (Button) findViewById(R.id.logDistributor);
        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRepLogin();
            }
        });
        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDisLogin();
            }
        });
    }

    private void openDisLogin() {
        Intent intent = new Intent(this, DistributorLoginActivity.class);
        startActivity(intent);
    }

    private void openRepLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}