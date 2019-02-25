package com.app.jpr.market.retrofit;


import com.app.jpr.market.models.LoginResponse;
import com.app.jpr.market.models.RegistrationResponse;

import okhttp3.RequestBody;
import retrofit2.Callback;

public class RestClient {
    private static final String TAG = "RestClient";


    public static void loginUser(RequestBody email, RequestBody password, Callback<LoginResponse> callback){
        RetrofitClient.getClient().login(email,password).enqueue(callback);
    }


    public static void registerUser(RequestBody name , RequestBody mobile, RequestBody country , RequestBody email , RequestBody password, Callback<RegistrationResponse> callback){
        RetrofitClient.getClient().register(name,mobile,country,email,password).enqueue(callback);
    }


}



