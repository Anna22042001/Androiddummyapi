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

public class Updating extends AppCompatActivity {
    Dataservice dataservice;
    EditText name, age, salary, id;
    Button update;
    int y = 24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updating);
        Intent intent = getIntent();
        y = intent.getIntExtra("number of employee",24);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Employee updated_employee = new Employee();
                    updated_employee.setEmployee_name(name.toString());
                    updated_employee.setEmployee_salary(salary.toString());
                    updated_employee.setEmployee_age(age.toString());

                    Call<Employee> call = dataservice.updateEmployee(Integer.parseInt(id.getText().toString()),updated_employee);
                    call.enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(Updating.this, "Employee updated sucy!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {
                            Toast.makeText(Updating.this,t.getMessage(),Toast.LENGTH_LONG).show();
                        }


                    });
                }

        });
    }
    private void setup(){
        name =  (EditText) findViewById(R.id.name2);
        age = (EditText) findViewById(R.id.age2);
        salary= (EditText) findViewById(R.id.salary2);
        update= (Button) findViewById(R.id.add2);
    }
}