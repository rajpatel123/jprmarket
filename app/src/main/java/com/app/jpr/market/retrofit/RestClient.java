package com.app.jpr.market.retrofit;


import okhttp3.RequestBody;
import retrofit2.Callback;

public class RestClient {
    private static final String TAG = "RestClient";


    public static void loginUser(RequestBody email, RequestBody password, Callback callback){
        RetrofitClient.getClient().login(email,password).enqueue(callback);
    }


}



