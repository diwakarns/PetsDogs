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

        insert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= fooditem.getText().toString();
                String contactTXT = served_by.getText().toString();
                String dobTXT = updated_by.getText().toString();
                String created_date1 = created_date.getText().toString();
                String update_date1 = update_date.getText().toString();
                Boolean checkinsertdata = DB.insertfeeddata(nameTXT, contactTXT, dobTXT,created_date1, update_date1);
                if(checkinsertdata == true)
                {
                    Toast.makeText(feed.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(feed.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}