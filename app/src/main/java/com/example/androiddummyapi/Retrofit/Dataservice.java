package com.example.androiddummyapi.Retrofit;

import com.example.androiddummyapi.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Dataservice {
    @GET("data")
    Call<List<Employee>> getdata();
    @POST("add/")
    Call<Employee> addEmployee(@Body  Employee employee);
    @PUT("update/{id}")
    Call<Employee> updateEmployee(@Path("id") int id, @Body Employee user);
    @DELETE("delete/{id}")
    Call<Employee> deleteEmployee(@Path("id") int id);


}
