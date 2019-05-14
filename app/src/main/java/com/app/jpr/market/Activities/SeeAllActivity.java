package com.app.jpr.market.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.jpr.market.R;
import com.app.jpr.market.adapter.CourseListAdapter;
import com.app.jpr.market.adapter.OfferAdapter.PlanAdapter;
import com.app.jpr.market.adapter.OfferAdapter.SavedBeyondGroceryAdapter;
import com.app.jpr.market.adapter.OfferAdapter.SmartBachatClubAdapter;
import com.app.jpr.market.adapter.SeeAllBestSelling.SeeAllBestSellingAdapter;
import com.app.jpr.market.models.BestSellingSeeAll.BestSellingNew;
import com.app.jpr.market.models.BestSellingSeeAll.SeeAllBestSelling;
import com.app.jpr.market.models.CatagoryResponse;
import com.app.jpr.market.models.dashboard.BestSelling;
import com.app.jpr.market.models.offer.Membership;
import com.app.jpr.market.models.offer.Plan;
import com.app.jpr.market.retrofit.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




        import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.app.jpr.market.R;
import com.app.jpr.market.adapter.CourseListAdapter;
import com.app.jpr.market.models.CatagoryResponse;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

        public class SeeAllActivity extends AppCompatActivity {
            private List<BestSellingNew> itemList4;
            RecyclerView recyclerView;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_see_all);
                recyclerView = findViewById(R.id.recycler_viewitem);

                getSeeAll();

            }


            private void getSeeAll() {
                Utils.showProgressDialog(this, "Please wait...");
                if (Utils.isInternetConnected(this)) {
                    Utils.showProgressDialog(this, "Please wait...");
                    RestClient.SeeAllss(new Callback<SeeAllBestSelling>() {
                        @Override
                        public void onResponse(Call<SeeAllBestSelling> call, Response<SeeAllBestSelling> response) {

                            Utils.dismissProgressDialog();
                            if (response.body() != null) {
                                if (response.body().getStatus()) {
                                    itemList4 = response.body().getBestSelling();



                                    SeeAllBestSellingAdapter seeAllBestSellingAdapter = new SeeAllBestSellingAdapter(getApplicationContext());
                                    seeAllBestSellingAdapter.setdata(itemList4);
                                    Log.d("Main Activity", "Done");
                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SeeAllActivity.this,LinearLayoutManager.VERTICAL,false);
                                    Log.d("Main Activity", "Two");
                                    recyclerView.setLayoutManager(linearLayoutManager);
                                    Log.d("Main Activity", "Three");
                                    recyclerView.setAdapter(seeAllBestSellingAdapter);
                                    Log.d("Main Activity", "Four");


                                    ////


                                   /* SavedBeyondGroceryAdapter savedBeyondGroceryAdapter = new SavedBeyondGroceryAdapter(getApplicationContext());
                                    Log.d("Price Activity","first");
                                    savedBeyondGroceryAdapter.setdata(itemList1);
                                    Log.d("Price Activity","first");
                                    LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(PriceActivity.this,LinearLayoutManager.HORIZONTAL,false);
                                    Log.d("Price Activity","first");
                                    recyclerView2.setLayoutManager(linearLayoutManager1);
                                    Log.d("Price Activity","first");
                                    recyclerView2.setAdapter(savedBeyondGroceryAdapter);
                                    Log.d("Price Activity","first");*/

                                  /*  SmartBachatClubAdapter smartBachatClubAdapter = new SmartBachatClubAdapter(getApplicationContext());
                                    Log.d("Price Activity","first");
                                    smartBachatClubAdapter.setdata(itemList2);
                                    Log.d("Price Activity","first");
                                    LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(PriceActivity.this,LinearLayoutManager.HORIZONTAL,false);
                                    Log.d("Price Activity","first");
                                    recyclerView3.setLayoutManager(linearLayoutManager2);
                                    Log.d("Price Activity","first");
                                    recyclerView3.setAdapter(smartBachatClubAdapter);
                                    Log.d("Price Activity","first");*/

                                 /*   PlanAdapter planAdapter1 = new PlanAdapter(getApplicationContext());
                                    planAdapter1.setdata(itemList3);
                                    Log.d("Main Activity", "Done");
                                    LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(PriceActivity.this,LinearLayoutManager.HORIZONTAL,false);
                                    Log.d("Main Activity", "Two");
                                    recyclerView4.setLayoutManager(linearLayoutManager3);
                                    Log.d("Main Activity", "Three");
                                    recyclerView4.setAdapter(planAdapter);
                                    Log.d("Main Activity", "Four");
*/

                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<SeeAllBestSelling> call, Throwable t) {
                            Toast.makeText(SeeAllActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            Utils.dismissProgressDialog();
                        }
                    });
                }
            }


            public void onResume()    {
                super.onResume();
            }

        }



