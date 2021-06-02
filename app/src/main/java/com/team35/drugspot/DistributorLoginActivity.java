package com.team35.drugspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DistributorLoginActivity extends AppCompatActivity {

    Button SignIn;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor_login);
        getSupportActionBar().hide();

        SignIn=findViewById(R.id.SignIn);
        register=findViewById(R.id.register);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDisLogin();
            }
        });

        SignIn.setOnClickListener(view ->
        {
            Intent intent = new Intent(this,DistributorUi.class);
            startActivity(intent);
        });
    }

    private void openDisLogin() {
        Intent intent = new Intent(this, DistributorUi.class);
        startActivity(intent);
    }

    private void register() {
        Intent intent = new Intent(this, RegisterDisActivity.class);
        startActivity(intent);
    }
}