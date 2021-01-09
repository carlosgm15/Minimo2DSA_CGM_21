package com.example.minimo2dsa_cgm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button explore;
    List<Follower> listDatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        explore = findViewById(R.id.see_followers);


        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, InfoUserActivity.class);
                myIntent.putExtra("User", name.getText().toString()); //pasara ademas del acctivity, pasara user en string m
                startActivity(myIntent);

            }
        });


    }
}
