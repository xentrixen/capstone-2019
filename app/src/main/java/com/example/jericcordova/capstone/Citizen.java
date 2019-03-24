package com.example.jericcordova.capstone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Citizen extends AppCompatActivity {

        private Button btnRegistration,btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen);

        btnRegistration =(Button) findViewById(R.id.btnRegistration);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Citizen.this, Registration.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Citizen.this,CitizenDrawer.class);
                startActivity(intent);
            }
        });
    }


}
