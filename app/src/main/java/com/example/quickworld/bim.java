package com.example.quickworld;import androidx.appcompat.app.AppCompatActivity;import androidx.core.app.ActivityCompat;import androidx.core.content.ContextCompat;import android.Manifest;import android.content.Context;import android.content.pm.PackageManager;import android.os.Bundle;import android.telephony.SmsManager;import android.view.View;import android.widget.Toast;public class bim extends AppCompatActivity {    private final static int SEND_SMS_PERMISSION_REQUEST_CODE = 111;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_bim);// Here, thisActivity is the current activity        if (ContextCompat.checkSelfPermission(this,                Manifest.permission.SEND_SMS)                != PackageManager.PERMISSION_GRANTED) {            // Permission is not granted            // Should we show an explanation?            if (ActivityCompat.shouldShowRequestPermissionRationale(this,                    Manifest.permission.SEND_SMS)) {                // Show an explanation to the user *asynchronously* -- don't block                // this thread waiting for the user's response! After the user                // sees the explanation, try again to request the permission.            } else {                // No explanation needed; request the permission                ActivityCompat.requestPermissions(this,                        new String[]{Manifest.permission.SEND_SMS},                        SEND_SMS_PERMISSION_REQUEST_CODE);                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an                // app-defined int constant. The callback method gets the                // result of the request.            }        } else {            // Permission has already been granted            findViewById(R.id.help_call).setOnClickListener(new View.OnClickListener() {                @Override                public void onClick(View view) {                    SmsManager msg = SmsManager.getDefault();                    msg.sendTextMessage("8700016973",null,"test message",null,null);                    Toast x = Toast.makeText(getApplicationContext(), "Message is send", Toast.LENGTH_SHORT);                    x.show();                }            });        }    }}