package com.example.androiddummyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androiddummyapi.CRUD.Adding;
import com.example.androiddummyapi.CRUD.Deleting;
import com.example.androiddummyapi.CRUD.Reading;
import com.example.androiddummyapi.CRUD.Updating;

public class MainActivity extends AppCompatActivity {
    Button get_data;
    Button add_employee;
    Button update_employee;
    Button delete_employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
        update_employee = (Button) findViewById(R.id.Updateid);
        get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Reading.class);
                startActivity(intent);
            }
        });
        add_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Adding.class);
                startActivity(intent1);
            }
        });
        update_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Updating.class);
                startActivity(intent2);
            }
        });
        delete_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, Deleting.class);
                startActivity(intent3);
            }
        });

    }
    private void setup(){
        get_data = (Button) findViewById(R.id.readid);
        add_employee = (Button) findViewById(R.id.Addid);
        delete_employee = (Button) findViewById(R.id.deleteid);
    }
}