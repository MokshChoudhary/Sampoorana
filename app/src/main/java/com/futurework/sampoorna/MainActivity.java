package com.futurework.sampoorna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.futurework.sampoorna.database.BlankContract;
import com.futurework.sampoorna.database.logindbProvider;
import com.futurework.sampoorna.ui.login.LoginActivity;
import com.futurework.sampoorna.database.logindbHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * here app decide were to go
         * If true then goto main page
         * Else Go to login page
         * */
        if(CheckForLogin()==true) {
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.slide_out_right);
            startActivity(new Intent(this,MainPage.class)
                    .putExtra("Username", new logindbProvider(new logindbHelper(this))
                            .getValueString(BlankContract.BlankEnter.COLUMNS_USER_NAME)));
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
        return new logindbProvider(new logindbHelper(this)).getCount()==0?false : true;

    }

}
