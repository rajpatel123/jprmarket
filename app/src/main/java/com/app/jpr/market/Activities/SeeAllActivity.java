package com.app.jpr.market.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.jpr.market.R;
import com.app.jpr.market.adapter.SeeAllBestSelling.SeeAllBestSellingAdapter;
import com.app.jpr.market.models.BestSellingSeeAll.BestSellingNew;
import com.app.jpr.market.models.BestSellingSeeAll.SeeAllBestSelling;
import com.app.jpr.market.retrofit.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.app.jpr.market.utils.Utils;

public class SeeAllActivity extends AppCompatActivity {
            private List<BestSellingNew> itemList;
            private ImageView arrow;

            RecyclerView recyclerView;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_see_all);
                recyclerView = findViewById(R.id.recycler_viewitem);
                arrow = findViewById(R.id.arrowimg1);

                arrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(SeeAllActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

                getAllItem();


            }



            private void getAllItem() {
                Utils.showProgressDialog(this, "Please wait...");
                if (Utils.isInternetConnected(this)) {
                    Utils.showProgressDialog(this, "Please wait...");
                    RestClient.allDataItemsss(new Callback<SeeAllBestSelling>() {
                        @Override
                        public void onResponse(Call<SeeAllBestSelling> call, Response<SeeAllBestSelling> response) {

                            Utils.dismissProgressDialog();
                            if (response.body() != null) {
                                if (response.body().getStatus()) {
                                    itemList = response.body().getBestSelling();


                                   SeeAllBestSellingAdapter seeAllBestSellingAdapter = new SeeAllBestSellingAdapter(getApplicationContext());
                                    seeAllBestSellingAdapter.setdata(itemList);
                                    Log.d("Main Activity", "Done");
                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SeeAllActivity.this,LinearLayoutManager.VERTICAL,false);
                                    Log.d("Main Activity", "Two");
                                    recyclerView.setLayoutManager(linearLayoutManager);
                                    Log.d("Main Activity", "Three");
                                    recyclerView.setAdapter(seeAllBestSellingAdapter);
                                    Log.d("Main Activity", "Four");

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
                public void onResume()  {
                super.onResume();
            }
        }





