package com.example.formactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    EditText editTextName, editTextEmail, editTextPhone, editTextAddress;
    Button buttonSubmit, buttonView;
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
        buttonView = findViewById(R.id.buttonView);

        dbHelper = new DatabaseHelper(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbHelper.getAllUsers();
                if (cursor.getCount() == 0) {
                    Log.d("DATABASE", "No data found");
                    return;
                }

                StringBuilder builder = new StringBuilder();
                while (cursor.moveToNext()) {
                    builder.append("ID: ").append(cursor.getInt(0)).append("\n")
                            .append("Name: ").append(cursor.getString(1)).append("\n")
                            .append("Email: ").append(cursor.getString(2)).append("\n")
                            .append("Phone: ").append(cursor.getString(3)).append("\n")
                            .append("Address: ").append(cursor.getString(4)).append("\n")
                            .append("-----------\n");
                }

                Log.d("DATABASE", builder.toString());
                cursor.close();
            }
        });
    }
}
