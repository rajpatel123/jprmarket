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


    public static void registerUser(RequestBody u_name , RequestBody u_email , RequestBody u_mobile, RequestBody u_country , RequestBody u_password, Callback<RegistrationResponse> callback){
        RetrofitClient.getClient().register(u_name,u_email,u_mobile,u_country,u_password).enqueue(callback);
    }


}



