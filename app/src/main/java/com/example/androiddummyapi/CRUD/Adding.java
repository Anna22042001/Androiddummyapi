package com.example.androiddummyapi.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androiddummyapi.Employee;
import com.example.androiddummyapi.R;
import com.example.androiddummyapi.Retrofit.Dataservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Adding extends AppCompatActivity {
    EditText name, age, salary;
    Button add;
    Dataservice dataservice;
    static int x = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        setup();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee new_employee= new Employee();
                new_employee.setId(x+1);
                x=x+1;
                new_employee.setEmployee_name(name.toString());
                new_employee.setEmployee_salary(salary.toString());
                new_employee.setEmployee_age(age.toString());
                Call<Employee> call = dataservice.addEmployee(new_employee);
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(Adding.this, "User created successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Adding.this, Updating.class);
                            Intent intent02 = new Intent(Adding.this, Deleting.class);
                            intent02.putExtra("number of employee",x);
                            startActivity(intent02);
                            intent.putExtra("number of employee",x);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {

                    }
                });

            }
        });
    }
    private void setup(){
        name =  (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        salary= (EditText) findViewById(R.id.salary);
        add= (Button) findViewById(R.id.add);
    }
}