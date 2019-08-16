package com.example.quickworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    //private ProgressBar p = findViewById(R.id.progressBar);
    //private int progressbarstatus = 0;
    public int hight;
    public int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);

        hight = display.heightPixels;
        hight = display.widthPixels;
        /*
        *TODO : here we have to check is user is login or not.
        * If no , then we goto "viewport"
        * other wise goto "mainpage"
        */

        //Code here for check
  /*  try {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressbarstatus < 100) {
                    progressbarstatus++;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }catch(Exception e){
        e.printStackTrace();
    }*/
        startActivity( new Intent(MainActivity.this,viewport.class) );
    }
}
