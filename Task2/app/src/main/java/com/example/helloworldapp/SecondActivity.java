package com.example.helloworldapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText editName;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editName = findViewById(R.id.editName);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString().trim();
                if (!name.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Hello, " + name + "!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecondActivity.this, "Please enter your name.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
