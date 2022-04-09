package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Dogs extends SQLiteOpenHelper {
    /*// below variable is for our database name.
    private static final String dbName = "Pets";

    // below int is our database version
    private static final int dbVersion = 1;

    // below variable is for table name.
    private static final String tableName = "Dogs";

    // below variable is for dogs Id.
    private static final String dogsId = "dogsId";

    // below variable is for dogs name.
    private static final String dogsName = "dogsName";

    // below variable is for our dogs color.
    private static final String dogsColor = "dogsColor";

    // below variable is for Warning
    private static final String precautions = "precautions";

    //below variable is for creation date automatic by system
  *//*  private static final String created_date = "Created_Date";

    //below variable is for update date automatic by system
    private static final String update_date = "update_date";
*/

    public Dogs(@Nullable Context context) {
        super(context, "Pets.db", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table Dogs(dogsId INTEGER primary key Autoincrement, " +
                "dogsName TEXT, " +
                "dogsColor TEXT," +
                "precautions TEXT  )");


        //To execute above sql query


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists Dogs");

    }


    public Boolean insertdogsdata(String dogsName, String dogsColor, String precautions  ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dogsName", dogsName);
        contentValues.put("dogsColor", dogsColor);
        contentValues.put("precautions", precautions);

        long result = sqLiteDatabase.insert("Dogs", null, contentValues);
       /* Log.d("Name", "insertdogsdata: " + "");*/

        if (result == -1)
        {
            return false;

        }
        else{
            return true;

        }


    }
}
