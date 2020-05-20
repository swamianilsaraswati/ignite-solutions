package com.example.singletonclassexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button saveData, getData, clearData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //edit text to input name
        editText = findViewById(R.id.editText);
        //save data button
        saveData = findViewById(R.id.saveData);
        //get data button
        getData = findViewById(R.id.getData);
        //clear data button
        clearData = findViewById(R.id.clearData);

        //on save data button click
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the name and converts to string
                String name = editText.getText().toString();
                //calls setter to set in shared preference
                SharedPreference.getInstance(getApplicationContext()).setName(name);
                Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_LONG).show();
                //reset the edit text to empty
                editText.setText("");
            }
        });

        //on get data button click
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieves the name from shared preference using getter
                String name = SharedPreference.getInstance(getApplicationContext()).getName();
                //setting to edit text to display to user
                editText.setText(name);
                Toast.makeText(getApplicationContext(),"Data Retrieved",Toast.LENGTH_LONG).show();
            }
        });

        //on clear data button click
        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call clearData()
                SharedPreference.getInstance(getApplicationContext()).clearData();
                Toast.makeText(getApplicationContext(),"Data Cleared",Toast.LENGTH_LONG).show();
                //getting name after clearing the data which will return empty string
                String name = SharedPreference.getInstance(getApplicationContext()).getName();
                //setting empty string to edit text
                editText.setText(name);
            }
        });
    }
}
