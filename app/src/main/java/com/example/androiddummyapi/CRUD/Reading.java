package com.example.androiddummyapi.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androiddummyapi.Employee;
import com.example.androiddummyapi.R;
import com.example.androiddummyapi.Retrofit.APIUtils;
import com.example.androiddummyapi.Retrofit.Dataservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Reading extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        textView= (TextView) findViewById(R.id.textView);
        Dataservice service = APIUtils.getDataservice();
        Call<List<Employee>> listCall = service.getdata();
        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if(!response.isSuccessful()){
                    textView.setText("Code:"+response.code());
                    return;
                }else{
                    List<Employee> list = response.body();
                    String profile="";
                    for(Employee employee:list){
                        profile+= "id: " + employee.getId() + "\n";
                        profile+= "Name: " + employee.getEmployee_name() + "\n";
                        profile+= "Salary: " + employee.getEmployee_salary() + "\n";
                        profile+= "Age: " + employee.getEmployee_age() + "\n\n";
                        textView.setText(profile);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}
