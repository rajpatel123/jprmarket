package com.app.jpr.market.retrofit;


import com.app.jpr.market.adapter.CourseListAdapter;
import com.app.jpr.market.models.CatagoryResponse;
import com.app.jpr.market.models.LoginResponse;
import com.app.jpr.market.models.RegistrationResponse;
import com.app.jpr.market.models.SubcategoryResponse;
import com.app.jpr.market.models.dashboard.CategoryResponse;
import com.app.jpr.market.models.offer.Membership;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    //login
    @Multipart
    @POST("cat_api/test_api.php?action=login")
    //@Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<LoginResponse>  login(@Part("u_email") RequestBody u_email,
                               @Part("u_password") RequestBody u_password);

    //Registration
    @Multipart
    @POST("cat_api/test_api.php?action=reg")
   //@Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<RegistrationResponse> register(@Part ("u_name")      RequestBody name,
                                         @Part("u_email")     RequestBody email,
                                         @Part ("u_mobile")   RequestBody mobile,
                                         @Part("u_country")   RequestBody country,
                                         @Part("u_password")  RequestBody password);


    //Catagory

    @POST("cat_api/test_api.php?action=fetch_all")
    Call <List<CatagoryResponse>> getCourse();


    @POST("grofer_api/list")
    Call <CategoryResponse> getAllItem();


    @POST("http://192.168.1.13/grofer_api/bachat_club")
    Call <Membership> getAllItems();



}
