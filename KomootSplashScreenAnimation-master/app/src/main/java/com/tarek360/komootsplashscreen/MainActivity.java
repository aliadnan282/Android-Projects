package com.tarek360.komootsplashscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private KomootDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Trash", "onCreate");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        drawable = new KomootDrawable();
        imageView.setImageDrawable(drawable);
        drawable.start();
    }
}
