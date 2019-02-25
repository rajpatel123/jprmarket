package com.app.jpr.market.retrofit;


import com.app.jpr.market.models.LoginResponse;
import com.app.jpr.market.models.RegResponce;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @Multipart
    @POST("api/test_api.php?action=login")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<LoginResponse>  login(@Part("u_email") RequestBody u_email, @Part("u_password") RequestBody u_password);

    @Multipart
    @POST("api/test_api.php?action=register")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<RegResponce>  register( @Part ("u_name") RequestBody u_name, @Part ("u_mobile") RequestBody u_mobile, @Part("u_country") RequestBody u_country, @Part("u_email") RequestBody u_email, @Part("u_password") RequestBody u_password);

//    @POST("api/test_api.php?action=signup")
//    Call<>

}
