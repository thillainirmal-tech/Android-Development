package com.example.formactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonOpenForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOpenForm = findViewById(R.id.buttonOpenForm);

        buttonOpenForm.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FormActivity.class);
            startActivity(intent);
        });
    }
}
