package com.app.jpr.market.retrofit;


import com.app.jpr.market.models.BestSellingSeeAll.SeeAllBestSelling;
import com.app.jpr.market.models.BlockBusterSeeAll.SeeAllBlockBuster;
import com.app.jpr.market.models.CatagoryResponse;
import com.app.jpr.market.models.Login.LoginResponse;
import com.app.jpr.market.models.Signup.RegistrationResponse;
import com.app.jpr.market.models.TopSaversSeeAll.SeeAllTopSavers;
import com.app.jpr.market.models.TabViewSubList.TabSubChildCatRequest;
import com.app.jpr.market.models.TabViewSubList.TabViewSubChildCatResponse;
import com.app.jpr.market.models.dashboard.CategoryResponse;
import com.app.jpr.market.models.offer.Membership;
import com.app.jpr.market.models.subCategory.SubCatResponse;
import com.app.jpr.market.models.subcatchildrequest.SubChildCatRequest;
import com.app.jpr.market.models.subcategoryrequest.SubCatRequest;
import com.app.jpr.market.models.subchildcategoryresponse.SubChildCatResponse;
import com.app.jpr.market.models.tablayout2response.Tab2SubChildCatRequest;
import com.app.jpr.market.models.tablayout2response.Tab2SubChildCatResponse;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    //login
    @Multipart
    @POST("cat_api/test_api.php?action=login")

    //@Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<LoginResponse>  login(@Part("u_email")    RequestBody u_email,
                               @Part("u_password") RequestBody u_password);

    //Registration
    @Multipart
    @POST("cat_api/test_api.php?action=reg")
  

   //@Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<RegistrationResponse> register( @Part ("u_name")     RequestBody name,
                                         @Part("u_email")     RequestBody email,
                                         @Part("u_mobile")    RequestBody mobile,
                                         @Part("u_country")   RequestBody country,
                                         @Part("u_password")  RequestBody password);


    //Catagory

    @POST("cat_api/test_api.php?action=fetch_all")
    Call <List<CatagoryResponse>> getCourse();


    @POST("grofer_api/list")
    Call <CategoryResponse> getAllItem();

    //Offers
    @POST("http://vrok.in/grofer_api/bachat_club")
    Call <Membership> getAllMemberItems();

    //See
    @POST("http://vrok.in/grofer_api/best_selling")
    Call <SeeAllBestSelling> getAllMemberItemss();

    //SeeAllBlockBuster
    @POST("http://vrok.in/grofer_api/blockbuster")
    Call <SeeAllBlockBuster> getAllMemberItemsss();

    //SeeAllTopSavers
    @POST("http://vrok.in/grofer_api/top_saver")
    Call <SeeAllTopSavers> getAllMemberItemssss();





    @POST("http://vrok.in/grofer_api/sub_catall")
    Call <SubCatResponse> getAllSubItem(@Body SubCatRequest subCatRequest);

    @POST("http://vrok.in/grofer_api/child_catall")
    Call <SubChildCatResponse> getAllSubChild(@Body SubChildCatRequest subChildCatRequest);

    @POST("http://vrok.in/grofer_api/fetch_by_cid")
    Call <TabViewSubChildCatResponse> tabProducts(@Body TabSubChildCatRequest tabSubChildCatRequest);

    @POST("http://vrok.in/grofer_api/fetch_by_cid")
    Call <Tab2SubChildCatResponse> tab2Products(@Body Tab2SubChildCatRequest tab2SubChildCatRequest);










}
