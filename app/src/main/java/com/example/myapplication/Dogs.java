package com.example.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Dogs extends SQLiteOpenHelper {
    // below variable is for our database name.
    private static final String dbName = "Pets.db";

    // below int is our database version
    private static final int dbVersion = 1;

    // below variable is for table name.
    private static final String tableName = "Dogs";

    // below variable is for dogs Id.
    private static final String dogsId = "dogs_id";

    // below variable is for dogs name.
    private static final String dogsName = "dogs_name";

    // below variable is for our dogs color.
    private static final String dogsColor = "dogs_color";

    // below variable is for Warning
    private static final String precautions = "warning";

    //below variable is for creation date automatic by system
    private static final String created_date = "Created_Date";

    //below variable is for update date automatic by system
    private static final String update_date = "update_date";


    public Dogs(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Dogs(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + tableName + " ("
                + dogsId + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + dogsName + " TEXT,"
                + dogsColor + " TEXT,"
                + precautions + " TEXT,"
                + update_date + "DATETIME,"
                + created_date + "DATETIME)";
        //To execute above sql query
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
