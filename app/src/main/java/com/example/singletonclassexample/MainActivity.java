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

        editText = findViewById(R.id.editText);
        saveData = findViewById(R.id.saveData);
        getData = findViewById(R.id.getData);
        clearData = findViewById(R.id.clearData);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                SharedPreference.getInstance(getApplicationContext()).setName(name);
                Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_LONG).show();
                editText.setText("");
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = SharedPreference.getInstance(getApplicationContext()).getName();
                editText.setText(name);
                Toast.makeText(getApplicationContext(),"Data Retrieved",Toast.LENGTH_LONG).show();
            }
        });

        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreference.getInstance(getApplicationContext()).clearData();
                Toast.makeText(getApplicationContext(),"Data Cleared",Toast.LENGTH_LONG).show();
                String name = SharedPreference.getInstance(getApplicationContext()).getName();
                editText.setText(name);
            }
        });
    }
}
