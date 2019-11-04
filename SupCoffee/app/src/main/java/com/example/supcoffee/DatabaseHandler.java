package com.example.supcoffee;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "coffee_list.db";
    private static final int DATABASE_VERSION = 1;

    public static final String COFFEE_TABLE = "coffees";
    public static final String COFFEE_KEY = "id";
    public static final String COFFEE_NAME = "name";
    public static final String COFFEE_RATE = "rate";

    public static final String COFFEE_TABLE_CREATE =
            "CREATE TABLE " + COFFEE_TABLE + " (" +
                    COFFEE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COFFEE_NAME + " TEXT, " +
                    COFFEE_RATE + " TEXT" +");";

    public static final String COFFEE_TABLE_DROP = "DROP TABLE IF EXISTS " + COFFEE_TABLE + ";";

    public DatabaseHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        dataBase.execSQL(COFFEE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int oldVersion, int newVersion) {
        dataBase.execSQL(COFFEE_TABLE_DROP);
        onCreate(dataBase);
    }
}
