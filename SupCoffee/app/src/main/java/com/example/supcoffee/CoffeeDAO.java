package com.example.supcoffee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoffeeDAO {

    private SQLiteDatabase database;
    private DatabaseHandler dbHelper;

    private String[] coffeeColumns = {
            DatabaseHandler.COFFEE_NAME,
            DatabaseHandler.COFFEE_RATE
    };

    public CoffeeDAO(Context context) {
        dbHelper = new DatabaseHandler(context, null);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public CoffeeObject addCoffee(String[] newCoffee){

        ContentValues values = new ContentValues();
        int index = 0;
        for (String columnHandler: coffeeColumns) {
            values.put(columnHandler, newCoffee[index]);
            index++;
        }
        long insertId = database.insert(DatabaseHandler.COFFEE_TABLE, null, values);
        Cursor cursor = database.query(DatabaseHandler.COFFEE_TABLE,
                coffeeColumns, DatabaseHandler.COFFEE_KEY + " = " + insertId,
                null,null, null, null);
        cursor.moveToFirst();
        CoffeeObject newCoffeeObj = cursorToCoffee(cursor);
        cursor.close();

        return newCoffeeObj;
    }

    public ArrayList<CoffeeObject> getCoffeeByName(String name){

        ArrayList<CoffeeObject> coffees = new ArrayList<CoffeeObject>();
        Cursor cursor = database.query(DatabaseHandler.COFFEE_TABLE, coffeeColumns, "name=?", new String[] { name }, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            CoffeeObject newUser = cursorToCoffee(cursor);
            coffees.add(newUser);
            cursor.moveToNext();
        }
        cursor.close();
        return coffees;
    }

    public ArrayList<CoffeeObject> getAllCoffees(){
        ArrayList<CoffeeObject> coffees = new ArrayList<CoffeeObject>();
        Cursor cursor = database.query(DatabaseHandler.COFFEE_TABLE, coffeeColumns, null, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            CoffeeObject newCoffee = cursorToCoffee(cursor);
            coffees.add(newCoffee);
            cursor.moveToNext();
        }
        cursor.close();

        return coffees;
    }

    private CoffeeObject cursorToCoffee(Cursor cursor) {
        return new CoffeeObject(
                cursor.getString(0),
                cursor.getString(1)
        );
    }
}
