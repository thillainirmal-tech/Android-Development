package com.example.helloworldapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonGreet, buttonOpenSecond, buttonOpenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button to show greeting Toast
        buttonGreet = findViewById(R.id.buttonGreet);
        buttonGreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome to HelloWorldApp!", Toast.LENGTH_SHORT).show();
            }
        });

        // Button to open SecondActivity
        buttonOpenSecond = findViewById(R.id.buttonOpenSecond);
        buttonOpenSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // Button to open ListActivity
        buttonOpenList = findViewById(R.id.buttonOpenList);
        buttonOpenList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
