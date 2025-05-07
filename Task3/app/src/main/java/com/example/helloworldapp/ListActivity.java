package com.example.helloworldapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    String[] fruits = {"Apple", "Banana", "Mango", "Orange", "Grapes", "Pineapple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);

        // Check if fruits array is being set correctly
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, // Layout for list item
                fruits // Array of items to be displayed
        );
        listView.setAdapter(adapter);
    }
}
