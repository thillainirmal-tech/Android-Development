package com.example.formactivity;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    // Declare the EditText fields and Button
    EditText editTextName, editTextEmail, editTextPhone, editTextAddress;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Initialize the EditText fields and Button
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set OnClickListener for the Submit Button
        buttonSubmit.setOnClickListener(view -> {
            // Get text from EditText fields
            String name = editTextName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String phone = editTextPhone.getText().toString().trim();
            String address = editTextAddress.getText().toString().trim();

            // Check if any field is empty
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, R.string.toast_fill_all_fields, Toast.LENGTH_SHORT).show();
            }
            // Check if the email format is valid
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, R.string.toast_invalid_email, Toast.LENGTH_SHORT).show();
            }
            else {
                // Show a Toast message confirming the form submission
                Toast.makeText(this, getString(R.string.toast_submitted, name), Toast.LENGTH_SHORT).show();

                // After submitting the form, refill the fields with new data
                refillForm();
            }
        });
    }

    // Method to refill the form with predefined data
    private void refillForm() {
        editTextName.setText("John Doe");  // Predefined Name
        editTextEmail.setText("john.doe@example.com");  // Predefined Email
        editTextPhone.setText("+1234567890");  // Predefined Phone
        editTextAddress.setText("123 Main Street, City");  // Predefined Address
    }
}
