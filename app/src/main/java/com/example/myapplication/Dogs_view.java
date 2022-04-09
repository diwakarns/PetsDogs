package com.example.myapplication;

import static java.lang.System.currentTimeMillis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dogs_view extends AppCompatActivity {

    EditText dogsName, precautions, dogsColor,update_date,created_date;
    Button insert1, viewdogdata,deletedogdata,updatedogdata;
    Dogs DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs_view);
        insert1 = findViewById(R.id.insert1);
        dogsName = findViewById(R.id.dogsName);
        precautions = findViewById(R.id.precautions);
        dogsColor = findViewById(R.id.dogsColor);
        viewdogdata = findViewById(R.id.viewdogdata);
        deletedogdata = findViewById(R.id.deletedogdata);
        updatedogdata = findViewById(R.id.updatedogdata);

        /*created_date = findViewById(R.id.created_date);
        update_date = findViewById(R.id.update_date);*/
        DB = new Dogs(this);
        insert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= dogsName.getText().toString();
                String contactTXT = precautions.getText().toString();
                String dobTXT = dogsColor.getText().toString();

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
        viewdogdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res= DB.getdogdata();

                if(res.getCount() ==  0 )
                {
                    Toast.makeText(Dogs_view.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("dogsId : " +res.getString(0)+ "\n" );
                    buffer.append("dogsName : " +res.getString(1)+ "\n" );
                    buffer.append("precautions : " +res.getString(2)+ "\n" );
                    buffer.append("dogsColor : " +res.getString(3)+ "\n\n" );

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Dogs_view.this);
                builder.setCancelable(true);
                builder.setTitle("User Entry ");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        updatedogdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= dogsName.getText().toString();
                String contactTXT = precautions.getText().toString();
                String dobTXT = dogsColor.getText().toString();

                Boolean checkupdatedata = DB.updatedogdata(nameTXT, contactTXT, dobTXT);
                if(checkupdatedata == true)
                {
                    Toast.makeText(Dogs_view.this, "  Entry Updated", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(Dogs_view.this, "Entry Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deletedogdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= dogsName.getText().toString();

                Boolean checkdeletedata = DB.deletedogdata(nameTXT );
                if(checkdeletedata == true)
                {
                    Toast.makeText(Dogs_view.this, "  Entry Deleted", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(Dogs_view.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}