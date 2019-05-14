package com.app.jpr.market.retrofit;


import com.app.jpr.market.models.CatagoryResponse;
import com.app.jpr.market.models.LoginResponse;
import com.app.jpr.market.models.RegistrationResponse;
import com.app.jpr.market.models.TabViewSubList.TabSubChildCatRequest;
import com.app.jpr.market.models.TabViewSubList.TabViewSubChildCatResponse;
import com.app.jpr.market.models.dashboard.CategoryResponse;
import com.app.jpr.market.models.subCategory.SubCatResponse;
import com.app.jpr.market.models.subcatchildrequest.SubChildCatRequest;
import com.app.jpr.market.models.subcategoryrequest.SubCatRequest;
import com.app.jpr.market.models.subchildcategoryresponse.SubChildCatResponse;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Callback;

public class RestClient {
    private static final String TAG = "RestClient";

    //Login
    public static void loginUser(RequestBody email, RequestBody password, Callback<LoginResponse> callback){
        RetrofitClient.getClient().login(email,password).enqueue(callback);
    }

    //Registration
   public static void registerUser(RequestBody u_name , RequestBody u_email , RequestBody u_mobile, RequestBody u_country , RequestBody u_password, Callback<RegistrationResponse> callback){
        RetrofitClient.getClient().register(u_name,u_email,u_mobile,u_country,u_password).enqueue(callback);
   }

    //Category
    public static void getCourses(Callback <List<CatagoryResponse>> callback) {
        RetrofitClient.getClient().getCourse().enqueue(callback);
    }

   //Dash board
    public static void allItems(Callback<CategoryResponse> callback) {
        RetrofitClient.getClient().getAllItem().enqueue(callback);
    }
  //subitem
    public static void SuballItems(SubCatRequest SubCatRequest, Callback<SubCatResponse> callback) {
        RetrofitClient.getClient().getAllSubItem(SubCatRequest).enqueue(callback);
    }

    public static void getAllSubCatChilds(SubChildCatRequest subChildCatRequest, Callback<SubChildCatResponse> callback) {
        RetrofitClient.getClient().getAllSubChild(subChildCatRequest).enqueue(callback);
    }

    public static void tabAllSubChild(TabSubChildCatRequest tabSubChildCatRequest, Callback<TabViewSubChildCatResponse> callback) {
        RetrofitClient.getClient().tabProducts(tabSubChildCatRequest).enqueue(callback);
    }
}



