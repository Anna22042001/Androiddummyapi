package com.example.androiddummyapi.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitClient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient(String url){
        if(retrofit == null){
            OkHttpClient builder = new OkHttpClient.Builder()
                    .writeTimeout(5000, TimeUnit.MILLISECONDS)
                    .readTimeout(5000, TimeUnit.MILLISECONDS)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(10000, TimeUnit.MILLISECONDS)
                    .build();
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder().baseUrl(url).client(builder)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }}
