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

        // Initialize buttons
        buttonGreet = findViewById(R.id.buttonGreet);
        buttonOpenSecond = findViewById(R.id.buttonOpenSecond);
        buttonOpenList = findViewById(R.id.buttonOpenList);

        // Show a welcome message
        buttonGreet.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "Welcome to HelloWorldApp!", Toast.LENGTH_SHORT).show()
        );

        // Open SecondActivity
        buttonOpenSecond.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // Open ListActivity
        buttonOpenList.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
        });
    }
}
