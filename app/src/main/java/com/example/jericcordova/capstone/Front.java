package com.example.jericcordova.capstone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Front extends AppCompatActivity {

    private Button btnCitizen,btnFirepersonnel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        btnFirepersonnel =(Button) findViewById(R.id.btnFirepersonnel);
        btnCitizen = (Button) findViewById(R.id.btnCitizen);

        btnCitizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Front.this, Citizen.class);
                startActivity(intent);
            }
        });

        btnFirepersonnel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Front.this,Firepersonnel.class);
                startActivity(intent);
            }
        });

    }

}
