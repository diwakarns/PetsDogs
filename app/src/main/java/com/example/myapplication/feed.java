package com.example.myapplication;

import static java.lang.System.currentTimeMillis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feed extends AppCompatActivity {


    EditText fooditem, served_by, updated_by,created_date,update_date;
    Button insert1;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        fooditem = findViewById(R.id.feedname);
        served_by = findViewById(R.id.served_by);
        updated_by = findViewById(R.id.updated_by);
        created_date = findViewById(R.id.created_date);
        update_date = findViewById(R.id.update_date);

        insert1 = findViewById(R.id.insert);

         DB = new DBHelper(this);


    }
}