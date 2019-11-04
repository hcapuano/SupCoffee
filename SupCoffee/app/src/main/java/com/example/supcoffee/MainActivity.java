package com.example.supcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListManagment listAdapter;
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<CoffeeObject> coffeeList;
    private CoffeeDAO dataCoffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dataCoffees = new CoffeeDAO(this);
        this.dataCoffees.open();

        this.coffeeList = dataCoffees.getAllCoffees();
        addCoffeeListAdapter();

        this.listAdapter = new ListManagment(list, this);
        ListView todoListView = (ListView)findViewById(R.id.coffee_list);
        todoListView.setAdapter(listAdapter);
    }

    public void addCoffeeListAdapter(){
        for (CoffeeObject currentCoffee : coffeeList) {
            String name = currentCoffee.getName();
            String rate = currentCoffee.getRate();
            list.add(name + " " + rate);
        }
    }

    public void buttonAddCoffee(View view) {
        finish();
        Intent intent = new Intent(this, AddCoffeeActivity.class);
        startActivity(intent);
    }
}
