package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dogs<Public> extends SQLiteOpenHelper {

    public Dogs(@Nullable Context context) {
        super(context, "Pets.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table Dogs(dogsId INTEGER primary key Autoincrement, " +
                "dogsName TEXT, " +
                "dogsColor TEXT," +
                "precautions TEXT)");


        //To execute above sql query


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("Name", "Hello ");
        sqLiteDatabase.execSQL("ALTER TABLE Dogs ADD COLUMN created_date DATETIME");
        sqLiteDatabase.execSQL("Drop Table if exists Dogs");
        onCreate(sqLiteDatabase);

    }




    public Boolean insertdogsdata(String dogsName, String dogsColor, String precautions, String created_date  ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dogsName", dogsName);
        contentValues.put("dogsColor", dogsColor);
        contentValues.put("precautions", precautions);
        contentValues.put("created_date", created_date);

        Log.d("Name2", "Word ");
        long result = sqLiteDatabase.insert("Dogs", null, contentValues);


        if (result == -1)
        {
            return false;

        }
        else{
            return true;

        }


    }

    public Cursor getdogdata(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Dogs", null);
        return cursor;

    }

    public Boolean deletedogdata(String dogsName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Dogs where dogsName = ?", new String[]{dogsName});
        if(cursor.getCount()>0){
            long result = sqLiteDatabase.delete("Dogs",  "dogsName=?", new String[]{dogsName});
            if (result == -1)
            {
                return false;

            }
            else{
                return true;

            }
        }else
        {
            return false;

        }
    }

    public Boolean updatedogdata( String dogsName, String dogsColor, String precautions){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dogsName", dogsName);
        contentValues.put("dogsColor", dogsColor);
        contentValues.put("precautions", precautions);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Dogs where dogsName = ?", new String[]{dogsName});

        if(cursor.getCount()>0){
            long result = sqLiteDatabase.update("Dogs",  contentValues, "dogsName=?", new String[]{dogsName});
            if (result == -1)
            {
                return false;

            }
            else{
                return true;

            }
        }else
        {
            return false;

        }
    }
}
