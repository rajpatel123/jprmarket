package com.app.jpr.market.retrofit;


import com.app.jpr.market.models.BestSellingSeeAll.SeeAllBestSelling;
import com.app.jpr.market.models.CatagoryResponse;
import com.app.jpr.market.models.Login.LoginResponse;
import com.app.jpr.market.models.Signup.RegistrationResponse;
import com.app.jpr.market.models.TabSubChildCatRequestNew;
import com.app.jpr.market.models.TabSubChildCatResponseNew;
import com.app.jpr.market.models.fragmentdatamodel.TabSubChildFragment;
import com.app.jpr.market.models.fragmentdatamodel.TabSubChildFragmentRequest;
import com.app.jpr.market.models.tablayout3response.Tab2SubChildCatRequest;
import com.app.jpr.market.models.tablayout3response.Tab2SubChildCatResponse;
import com.app.jpr.market.models.tablayoutresponse.TabSubChildCatRequest;
import com.app.jpr.market.models.tablayoutresponse.TabViewSubChildCatResponse;
import com.app.jpr.market.models.dashboard.CategoryResponse;
import com.app.jpr.market.models.offer.Membership;
import com.app.jpr.market.models.subCategory.SubCatResponse;
import com.app.jpr.market.models.subcatchildrequest.SubChildCatRequest;
import com.app.jpr.market.models.subcategoryrequest.SubCatRequest;
import com.app.jpr.market.models.subchildcategoryresponse.SubChildCatResponse;
import com.app.jpr.market.models.tablayouttitle.TabLayoutTitleRequest;
import com.app.jpr.market.models.tablayouttitle.TabLayoutTitleResponse;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Callback;

public class RestClient {
    private static final String TAG = "RestClient";


    public static void tabAllSubChildNew2(TabSubChildCatRequestNew tabSubChildCatRequestNew, Callback<TabSubChildCatResponseNew> callback) {
        RetrofitClient.getClient().getAllSubChildNew(tabSubChildCatRequestNew).enqueue(callback);
    }
    public static void tabAllSubChildNewFragment(TabSubChildFragmentRequest tabSubChildFragmentRequest, Callback<TabSubChildFragment> callback) {
        RetrofitClient.getClient().getAllSubChildFragment(tabSubChildFragmentRequest).enqueue(callback);
    }

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


    //Offers
    public static void allDataItemss(Callback<Membership> callback) {
        RetrofitClient.getClient().getAllMemberItems().enqueue(callback);
    }

    //SeeAllBestSelling
    public static void allDataItemsss(Callback<SeeAllBestSelling> callback) {
        RetrofitClient.getClient().getAllMemberItemss().enqueue(callback);
    }

    //SeeAllBlockBuster
   /* public static void allBlockDataItems(  Callback<SeeAllBlockBuster> callback) {
        RetrofitClient.getClient().getAllBlockBusterMemberItems().enqueue(callback);
    }
*/
  /*  public static void tabAllSubChild(TabSubChildCatRequest tabSubChildCatRequest, Callback<TabViewSubChildCatResponse> callback) {
        RetrofitClient.getClient().tabProducts(tabSubChildCatRequest).enqueue(callback);
    }*/


   /* //SeeAllTopSavers
    public static void allDataItemsssss(Callback<SeeAllTopSavers> callback) {
        RetrofitClient.getClient().getAllMemberItemssss().enqueue(callback);
    }*/


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

    //tablayout
    public static void tabAllSubChild(TabSubChildCatRequest tabSubChildCatRequest, Callback<TabViewSubChildCatResponse> callback) {
        RetrofitClient.getClient().tabProducts(tabSubChildCatRequest).enqueue(callback);
    }
   //tablayout2api
    public static void tab2AllSubChild(Tab2SubChildCatRequest tab2SubChildCatRequest, Callback<Tab2SubChildCatResponse> callback) {
        RetrofitClient.getClient().tab2Products(tab2SubChildCatRequest).enqueue(callback);
    }
    public static void tab2TitleSubChild(TabLayoutTitleRequest tabLayoutTitleRequest, Callback<TabLayoutTitleResponse> callback) {
        RetrofitClient.getClient().getAlltitleSubItem(tabLayoutTitleRequest).enqueue(callback);
    }



}



