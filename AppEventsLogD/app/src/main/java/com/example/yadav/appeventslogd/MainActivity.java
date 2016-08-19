package com.example.yadav.appeventslogd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Mylogs","onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Mylogs","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Mylogs","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Mylogs","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Mylogs","onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Mylogs","onRestart()");
    }
}
