package com.futurework.sampoorna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.futurework.sampoorna.database.BlankContract;
import com.futurework.sampoorna.database.logindbHelper;
import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class signin extends AppCompatActivity {

    private Spinner spinner_gender,spinner_blood,spinner_date,spinner_month,spinner_year;
    private  EditText username;
    private  EditText weight;
    private  EditText pass;
    private  EditText repass;
    private ArrayList dateList = new ArrayList<String>();
    private int gender ;
    private com.futurework.sampoorna.database.logindbHelper mdbhelper = new logindbHelper(this);
    private int t;
    private int blood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        weight = findViewById(R.id.weight);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        repass = findViewById(R.id.repassword);

        spinner_blood = findViewById(R.id.blood);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_blood,android.R.layout.simple_gallery_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_blood.setAdapter(adapter);

        spinner_gender = findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.spinner_gender,android.R.layout.simple_gallery_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_gender.setAdapter(adapter1);
        dateList.add("Date");
        ArrayList MonthList = new ArrayList<String>();
        MonthList.add("Month");
        for(int j=1;j<=12;j++){
            if(j<0){
                MonthList.add("0"+j);
            }else{
                MonthList.add(j+"");
            }
        }

        DateFormat dateFormat = new SimpleDateFormat("y");
        Date date = new Date();
        int year = Integer.parseInt(dateFormat.format(date));
        ArrayList YearList = new ArrayList<String>();
        YearList.add("Year");
        for(int k=year;k>year-100;k--){
            YearList.add(k+"");
        }

        spinner_date = findViewById(R.id.date);
        final ArrayAdapter<String> date_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,dateList);
        date_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_date.setAdapter(date_adapter);

        spinner_month =findViewById(R.id.month);
        final ArrayAdapter<String> month_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,MonthList);
        month_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_month.setAdapter(month_adapter);

        spinner_year =findViewById(R.id.year);
        ArrayAdapter<String> year_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,YearList);
        year_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_year.setAdapter(year_adapter);

        spinner_blood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch((String)spinner_blood.getSelectedItem()){
                    case "O+":
                        blood =1;
                        break;
                    case "O-":
                        blood =-1;
                        break;
                    case "A+":
                        blood = 2;
                        break;
                    case "A-":
                        blood = -2;
                        break;
                    case "B+":
                        blood =3;
                        break;
                    case "B-":
                        blood = -3;
                        break;
                    case "AB+":
                        blood = 4;
                        break;
                    case "AB-":
                        blood = -4;
                        break;
                    default:
                        blood = 0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch((String)spinner_gender.getSelectedItem()){
                    case "Male":
                        gender =1;
                        break;
                    case "Female":
                        gender=2;
                        break;
                    default:
                        gender =0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                gender = 0;
            }
        });

        spinner_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch((String)spinner_month.getSelectedItem()){
                    case 1+"":
                        t=01;
                        break;
                    case 2+"":
                        t=02;
                        break;
                    case ""+3:
                        t=03;
                        break;
                    case 4+"":
                        t=04;
                        break;
                    case 5+"":
                        t=05;
                        break;
                    case 6+"":
                        t=06;
                        break;
                    case 7+"":
                        t=07;
                        break;
                    case 8+"":
                        t= 8;
                        break;
                    case 9+"":
                        t= 9;
                        break;
                    case 10+"":
                        t=10;
                        break;
                    case 11+"":
                        t=11;
                        break;
                    case 12+"":
                        t=12;
                        break;
                    default:
                        t =0;
                }
                dateList.clear();
                dateList.add("Date");
                if(t == 0){
                    spinner_date.setEnabled(false);
                }else{
                    spinner_date.setEnabled(true);
                    if(t==2){
                        for(int i=1;i<29;i++){
                            if(i<0){
                                dateList.add("0"+i);
                            }else{
                                dateList.add(i);
                            }
                        }
                    }else if( t%2 == 0 ){
                        for(int i=1;i<32;i++){
                            if(i<0){
                                dateList.add("0"+i);
                            }else{
                                dateList.add(i);
                            }
                        }
                    }else{
                        for(int j = 1;j<31;j++){
                            if(j<0){
                                dateList.add("0"+j);
                            }else{
                                dateList.add(j);
                            }
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.letsgo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CREATION",username.getText()+"");
                Log.d("CREATION",""+spinner_year.getSelectedItem());
                Log.d("CREATION",""+spinner_blood.getSelectedItem());
                Log.d("CREATION",""+spinner_date.getSelectedItem());
                Log.d("CREATION",""+spinner_gender.getSelectedItem());
                Log.d("CREATION",""+spinner_date.getSelectedItem());
                Log.d("CREATION",""+spinner_month.getSelectedItem());
                if(username.getText().toString().isEmpty()){
                    username.setError("Username is empty");
                }else if(!invalidUserName(username.getText().toString())){
                    username.setError("Invalid Username");
                }else if(pass.getText().toString().isEmpty()){
                    pass.setError("Enter Password");
                }else if(repass.getText().toString().isEmpty()){
                    repass.setError("Re-Enter Password");
                }/*else if(pass.getText().toString().trim().equals(repass.getText().toString().trim())){
                    repass.setError("Password don't match");
                }*/else if(spinner_date.getSelectedItem()=="Date" | spinner_month.getSelectedItem() == "Month" | spinner_year.getSelectedItem() == "Year"){
                    Snackbar.make(v,"Enter your date of birth",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }
                else{
                    ContentValues values = new ContentValues();
                    SQLiteDatabase db = mdbhelper.getWritableDatabase();

                    values.put(BlankContract.BlankEnter._ID, String.valueOf(values));
                    values.put(BlankContract.BlankEnter.COLUMNS_USER_NAME, String.valueOf(username.getText()));
                    values.put(BlankContract.BlankEnter.COLUMNS_USER_DOB,""+spinner_date.getSelectedItem()+spinner_month.getSelectedItem()+spinner_year.getSelectedItem());
                    values.put(BlankContract.BlankEnter.COLUMNS_USER_BLOOD,blood);
                    values.put(BlankContract.BlankEnter.COLUMNS_USER_GENDER,gender);
                    values.put(BlankContract.BlankEnter.COLUMNS_USER_WEIGHT,Integer.parseInt(String.valueOf(weight.getText())));
                    values.put(BlankContract.BlankEnter.COLUMNS_USER_PASSWORD, String.valueOf(pass.getText()));
                    Log.d("CREATOR",""+values);
                    long result = db.insert(BlankContract.BlankEnter.LOGIN_TABLE_NAME,null,values);

                    if(result == -1){
                        Toast.makeText(getApplicationContext(), "Sign up failed!!", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Welcome! "+username.getText(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(signin.this,MainPage.class).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                    }

                }
            }
        });

    }

    private boolean invalidUserName(String username){
        if(username.matches("[[^!@#$%&*(){}]*]")){
            return false;
        }else return true;
    }

}
