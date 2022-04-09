package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dogs_view extends AppCompatActivity {

    EditText dogsName, precautions, dogsColor,update_date,created_date;
    Button insert1;
    Dogs DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs_view);
        insert1 = findViewById(R.id.insert1);
        dogsName = findViewById(R.id.dogsName);
        precautions = findViewById(R.id.precautions);
        dogsColor = findViewById(R.id.dogsColor);
       /* update_date = findViewById(R.id.update_date);
        created_date = findViewById(R.id.created_date);*/
        DB = new Dogs(this);
        insert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= dogsName.getText().toString();
                String contactTXT = precautions.getText().toString();
                String dobTXT = dogsColor.getText().toString();
              /*  String created_date1 = update_date.getText().toString();
                String update_date1 = created_date.getText().toString();*/
                Boolean checkinsertdata = DB.insertdogsdata(nameTXT, contactTXT, dobTXT );
                if(checkinsertdata == true)
                {
                    Toast.makeText(Dogs_view.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(Dogs_view.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}