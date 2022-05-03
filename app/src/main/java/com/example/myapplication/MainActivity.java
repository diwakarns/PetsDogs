package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button insert,view,feeddogs,viewdogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // hide the title bar

        text = findViewById(R.id.text);
        insert = findViewById(R.id.insert);
        view = findViewById(R.id.view);
        feeddogs = findViewById(R.id.feeddogs);
        viewdogs = findViewById(R.id.viewdogs);

         insert.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, Dog.class);
                 startActivity(intent);
             }
         });




    }

}
