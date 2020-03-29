package com.futurework.sampoorna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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

import com.futurework.sampoorna.database.BlankContract;
import com.futurework.sampoorna.database.logindbHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class signin extends AppCompatActivity {
    private Spinner spinner_gender,spinner_blood,spinner_date,spinner_month,spinner_year;
    private EditText username = findViewById(R.id.username);
    private EditText weight = findViewById(R.id.weight);
    private EditText pass = findViewById(R.id.password);
    private EditText repass = findViewById(R.id.repassword);
    private ArrayList dateList = new ArrayList<String>();
    private int gender ;
    private com.futurework.sampoorna.database.logindbHelper mdbhelper = new logindbHelper(this);
    private int t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

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
            MonthList.add(j+"");
        }

        DateFormat dateFormat = new SimpleDateFormat("y");
        Date date = new Date();
        int year = Integer.parseInt(dateFormat.format(date));
        ArrayList YearList = new ArrayList<String>();
        YearList.add("Year");
        for(int k=year-100;k<year;k++){
            YearList.add(k+"");
        }

        spinner_date = findViewById(R.id.date);
        final ArrayAdapter<String> date_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,dateList);
        date_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_date.setAdapter(date_adapter);

        spinner_month =findViewById(R.id.month);
        ArrayAdapter<String> month_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,MonthList);
        month_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_month.setAdapter(month_adapter);

        spinner_year =findViewById(R.id.year);
        ArrayAdapter<String> year_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,YearList);
        year_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_year.setAdapter(year_adapter);

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
                        t=1;
                        break;
                    case 2+"":
                        t=2;
                        break;
                    case ""+3:
                        t=3;
                        break;
                    case 4+"":
                        t=4;
                        break;
                    case 5+"":
                        t=5;
                        break;
                    case 6+"":
                        t=6;
                        break;
                    case 7+"":
                        t=7;
                        break;
                    case 8+"":
                        t=8;
                        break;
                    case 9+"":
                        t=9;
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
                            dateList.add(i);
                        }
                    }else if( t%2 == 0 ){
                        for(int i=1;i<32;i++){
                            dateList.add(i);
                        }
                    }else{
                        for(int j = 1;j<31;j++){
                            dateList.add(j);
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
                Log.d("CREATION",""+spinner_year.getSelectedItem());
                Log.d("CREATION",""+spinner_blood.getSelectedItem());
                Log.d("CREATION",""+spinner_date.getSelectedItem());
                Log.d("CREATION",""+spinner_gender.getSelectedItem());
                Log.d("CREATION",""+spinner_date.getSelectedItem());
                Log.d("CREATION",""+spinner_month.getSelectedItem());
                ContentValues values = new ContentValues();
                SQLiteDatabase db = mdbhelper.getWritableDatabase();

                values.put(BlankContract.BlankEnter._ID,String.valueOf(values));
                values.put(BlankContract.BlankEnter.COLUMNS_USER_NAME, String.valueOf(username.getText()));
                //values.put(BlankContract.BlankEnter.COLUMNS_USER_DOB,Integer.parseInt((String)spinner_date+spinner_month+spinner_year));
                values.put(BlankContract.BlankEnter.COLUMNS_USER_BLOOD,String.valueOf(spinner_blood));
                values.put(BlankContract.BlankEnter.COLUMNS_USER_GENDER,gender);
                values.put(BlankContract.BlankEnter.COLUMNS_USER_WEIGHT,String.valueOf(weight.getText()));

                long result = db.insert(BlankContract.BlankEnter.LOGIN_TABLE_NAME,null,values);

            }
        });

    }


}
