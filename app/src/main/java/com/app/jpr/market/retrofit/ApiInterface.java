package com.app.jpr.market.retrofit;


import com.app.jpr.market.models.LoginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @Multipart
    @POST("api/test_api.php?action=login")
    Call<LoginResponse>  login(@Part("u_email") RequestBody u_email, @Part("u_password") RequestBody u_password);


//    @POST("api/test_api.php?action=signup")
//    Call<>

}
