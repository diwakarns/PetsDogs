package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Society extends SQLiteOpenHelper {


    // below variable is for our database name.
    private static final String dbName = "pets";

    // below int is our database version
    private static final int dbVersion = 1;

    // below variable is for our table name.
    private static final String tableName = "Society";

    // below variable is for our id column.
    private static final String socId = "society_id";

    // below variable is for our society name.
    private static final String socName = "society_name";

    // below variable is for our Wing.
    private static final String wingName = "wing_name";

    public Society(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String query = "CREATE TABLE " + tableName + " ("
                + socId + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + socName + " TEXT,"
                + wingName + " TEXT)";

      //To execute above sql query
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
