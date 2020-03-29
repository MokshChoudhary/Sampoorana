package com.futurework.sampoorna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.futurework.sampoorna.database.BlankContract;
import com.futurework.sampoorna.ui.login.LoginActivity;
import com.futurework.sampoorna.database.logindbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * here app decide were to go
         * If true then goto Into main page
         * Else Go to login page
         * */
        if(CheckForLogin()==true) {
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.slide_out_right);
            startActivity(new Intent(this,MainPage.class));
        }else{
           Intent I = new Intent(this,LoginActivity.class);
           overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in);
           startActivity(I);
        }
    }
    /**
     * @CheckForLogin : use for checking the user is logged in or not , And
     * Return true if logged in
     * else Return false
     * */
    private boolean CheckForLogin(){
        logindbHelper dbHelper = new logindbHelper(this);
        SQLiteDatabase read = dbHelper.getReadableDatabase();
        Cursor cursor;
        cursor = read.query(
                BlankContract.BlankEnter.LOGIN_TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        try{
            return cursor.getCount()==0?false : true;
        }finally {
            cursor.close();
        }

    }

}
