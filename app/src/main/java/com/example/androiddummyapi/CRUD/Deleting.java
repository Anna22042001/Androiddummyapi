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

public class Deleting extends AppCompatActivity {
    Dataservice dataservice;
    EditText id;
    Button delete;
    int z = 24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleting);
        id = (EditText) findViewById(R.id.id2);
        delete= (Button) findViewById(R.id.delete);
        Intent intent = getIntent();
        z = intent.getIntExtra("number of employee",24);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* int idno =  Integer.parseInt(id.getText().toString());
                if(idno>24){
                    Toast.makeText(Deleting.this,"Out of Bound",Toast.LENGTH_LONG).show();
                }else{*/
                Call<Employee> call = dataservice.deleteEmployee(Integer.parseInt(id.getText().toString()));
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(Deleting.this, "User deleted successfully!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Toast.makeText(Deleting.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        }
}