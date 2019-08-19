package com.example.quickworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class mainframe extends AppCompatActivity {
    private ArrayList<dataset> temp;
    private ListView ls;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainframe);
        Button c = findViewById(R.id.call_sos);
        ls = findViewById(R.id.list);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(mainframe.this,bim.class);
                startActivity(call);
            }
        });

        findViewById(R.id.call_daily).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = new ArrayList<>();
                temp.add(new dataset(2,"temp ","temp discription"));
                temp.add(new dataset(2,"temp ","temp discription"));
                dataabapter adapter = new dataabapter(this,0,temp);
                ls.setAdapter(adapter);
            }
        });

        findViewById(R.id.call_Avoid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
