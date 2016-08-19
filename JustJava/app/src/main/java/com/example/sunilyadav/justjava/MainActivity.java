package com.example.sunilyadav.justjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    int number = 2;
    public void setorder(View view){
        display(number);
        displayPrice(number*100);
    }
    public void display(int number){
        TextView mytextview = (TextView) findViewById(R.id.ordertext);
        mytextview.setText(""+number);
    }

    public void displayPrice(int price){
        TextView priceTextView = (TextView) findViewById(R.id.pricetext);
        priceTextView.setText("$"+price);
    }
    public void increase(View view){
        number = number + 1;
        display(number);
    }
    public void decrease(View view){
        number = number - 1;
        display(number);
    }
}
