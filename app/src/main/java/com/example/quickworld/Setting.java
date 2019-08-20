package com.example.quickworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViewById(R.id.qqq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText x = findViewById(R.id.www);
                datahandle.ph = x.getText().toString();
                startActivity(new Intent(Setting.this,bim.class));
                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
            }
        });
    }
}
