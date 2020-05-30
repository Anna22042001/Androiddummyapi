package com.example.androiddummyapi.Retrofit;


public class APIUtils {
    public static final String Base_url = "https://my-json-server.typicode.com/Anna22042001/androidinternship/data/";
    public static Dataservice getDataservice(){

        return RetrofitClient.getClient(Base_url).create(Dataservice.class);
    }
}
