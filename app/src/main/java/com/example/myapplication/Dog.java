package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Dog extends AppCompatActivity {

    private Button Submitsociety;
    private EditText createdby, editTextTextEmailAddress;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);

        Submitsociety = findViewById(R.id.Submitsociety);
        createdby = findViewById(R.id.createdby);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        title = findViewById(R.id.title);



    }
}