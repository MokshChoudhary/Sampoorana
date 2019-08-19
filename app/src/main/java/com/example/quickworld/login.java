package com.example.quickworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private  EditText u;
    private  EditText p;
    private datahandle call_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        u = findViewById(R.id.user);
        p = findViewById(R.id.password);
        call_me = new datahandle();
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(call_me.checkuser(u.getText().toString()) && call_me.checkpass(p.getText().toString())  ){
                    startActivity(new Intent(login.this,mainframe.class));
                }else {
                    Toast x = Toast.makeText(getApplicationContext(),"Username/Password is wrong",Toast.LENGTH_SHORT);
                    x.show();
                }
            }
        });
    }
}
