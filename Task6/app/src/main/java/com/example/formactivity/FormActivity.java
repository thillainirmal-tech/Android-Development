package com.example.formactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    EditText editTextName, editTextEmail, editTextPhone, editTextAddress;
    Button buttonSubmit, buttonNavigate;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonNavigate = findViewById(R.id.buttonNavigate);

        dbHelper = new DatabaseHelper(this);

        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String phone = editTextPhone.getText().toString();
            String address = editTextAddress.getText().toString();

            boolean isInserted = dbHelper.insertUser(name, email, phone, address);
            if (isInserted) {
                Toast.makeText(FormActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(FormActivity.this, "Data insert failed", Toast.LENGTH_SHORT).show();
            }
        });

        buttonNavigate.setOnClickListener(v -> {
            // Get data from EditText fields
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String phone = editTextPhone.getText().toString();
            String address = editTextAddress.getText().toString();

            // Pass data to SecondActivity
            Intent intent = new Intent(FormActivity.this, SecondActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("address", address);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }
}
