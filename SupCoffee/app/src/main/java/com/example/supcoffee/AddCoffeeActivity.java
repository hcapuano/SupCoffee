package com.example.supcoffee;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AddCoffeeActivity extends AppCompatActivity {

    private CoffeeDAO dataCoffees;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coffee);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.addListCoffee);
        layout.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent ev)
            {
                hideKeyboard(view);
                return false;
            }
        });

        this.dataCoffees = new CoffeeDAO(this);
        this.dataCoffees.open();

    }

    protected void hideKeyboard(View view)
    {
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void addCoffeeForm(View view) {

        EditText name = findViewById(R.id.name);
        EditText rate = findViewById(R.id.rate);

        if (name.getText() != null && rate.getText() != null){

            CoffeeObject newCoffee = dataCoffees.addCoffee(
                new String[]{
                        name.getText().toString(),
                        rate.getText().toString()
                }
            );

            if (newCoffee != null){
                finish();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Can't create a new coffee", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Check your fields", Toast.LENGTH_LONG).show();
        }

    }

    public void cancel(View view) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
