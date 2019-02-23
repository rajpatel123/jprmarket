package com.example.kishan.grofers.retrofit;


import com.example.kishan.grofers.models.LoginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @POST("api/test_api.php?action=login")
    Call<LoginResponse>  login(@Part("u_email") RequestBody u_email,@Part("u_password") RequestBody u_password);



}
