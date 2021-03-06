package com.app.jpr.market.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.jpr.market.R;
import com.app.jpr.market.adapter.SubItemListAdapter;
import com.app.jpr.market.models.subCategory.SubCatResponse;
import com.app.jpr.market.models.subcategoryrequest.SubCatRequest;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubCategoryActivity extends AppCompatActivity {
    private SubCatResponse subcatitem;
    private RecyclerView recyclerViewSubItem;
    private String cat_id;
    private ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        recyclerViewSubItem = findViewById(R.id.subitemcategoryRecycler);
        arrow=findViewById(R.id.arrowimg1);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SubCategoryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        getSubCatItem();
    }


    private void getSubCatItem() {


        if (getIntent().hasExtra("id")) {
            cat_id = String.valueOf(getIntent().getStringExtra("id"));
        }
        SubCatRequest subCatRequest = new SubCatRequest();
        subCatRequest.setCatId(cat_id);


        Utils.showProgressDialog(this, "Please wait...");
        if (Utils.isInternetConnected(this)) {
            Utils.showProgressDialog(this, "Please wait...");
            RestClient.SuballItems(subCatRequest, new Callback<SubCatResponse>() {
                @Override
                public void onResponse(Call<SubCatResponse> call, Response<SubCatResponse> response) {

                    Utils.dismissProgressDialog();
                    if (response.body() != null) {

                        if (response.body().getStatus()) {


                            subcatitem = response.body();
                            if (subcatitem != null && subcatitem.getSubCategories().size() > 0) {

                                SubItemListAdapter subItemListAdapter = new SubItemListAdapter(getApplicationContext());
                                subItemListAdapter.setdata(subcatitem.getSubCategories());

                                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
                                gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                                recyclerViewSubItem.setLayoutManager(gridLayoutManager);
                                recyclerViewSubItem.setAdapter(subItemListAdapter);

                                subItemListAdapter.setSellingListInterface(new SubItemListAdapter.SellingListInterface() {
                                    @Override
                                    public void sellinglistitem(String id) {
                                        Intent intent = new Intent(SubCategoryActivity.this, TabLayoutActivity.class);
                                        intent.putExtra("id", id);
                                        startActivity(intent);

                                    }
                                });


                            }
                        }

                    }
                }
                @Override
                public void onFailure(Call<SubCatResponse> call, Throwable t) {
                    Toast.makeText(SubCategoryActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    Utils.dismissProgressDialog();

                }

            });
        } else {
            Toast.makeText(this, "Internet Connection Failed", Toast.LENGTH_SHORT).show();
        }
    }
}