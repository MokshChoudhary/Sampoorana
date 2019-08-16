package com.example.quickworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class signip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signip);

        // in gender spinner i add genders(Male ,Female ,Other)

        Spinner spinner =  findViewById(R.id.gender);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.Gender, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_2);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // in blood group  spinner i add blood group(+A ,-A ,+B ,-B ,+AB ,-AB ,+O ,-O)
        Spinner blood_group = findViewById(R.id.blood_group);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.blood_group, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        // Apply the adapter to the spinner
        blood_group.setAdapter(adapter1);

        /*
         *
         * TODO: Add the database in this
         */

        //void entertodatabase()

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(signip.this,mainframe.class);
                startActivity(call);
            }
        });

    }
}
