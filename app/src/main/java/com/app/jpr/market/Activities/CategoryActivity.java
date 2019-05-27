package com.app.jpr.market.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;


import com.app.jpr.market.R;
import com.app.jpr.market.adapter.CourseListAdapter;
import com.app.jpr.market.adapter.DashboardAdapter.BestSellingAdapter;
import com.app.jpr.market.adapter.DashboardAdapter.BlockBusterAdapter;
import com.app.jpr.market.adapter.DashboardAdapter.CategoryDashboardAdapter;
import com.app.jpr.market.models.CatagoryResponse;
import com.app.jpr.market.models.dashboard.BestSelling;
import com.app.jpr.market.models.dashboard.BlockbusterSaver;
import com.app.jpr.market.models.dashboard.Category;
import com.app.jpr.market.models.dashboard.CategoryResponse;
import com.app.jpr.market.models.dashboard.TodaySaver;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {


    private List<Category> itemList1;
    private RecyclerView recyclerView1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView1 = findViewById(R.id.recycler);
        getAllItem();

        ///show back button
        if(getSupportActionBar()!=null){                                                                                  ///
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);                                                       ///
            getSupportActionBar().setDisplayShowHomeEnabled(true);                                                       ///

        }
    }





    @Override  //add cart code
    public boolean onCreateOptionsMenu(Menu menu) {                                             //
        // Inflate the menu; this adds items to the action bar if it is present.               //
        getMenuInflater().inflate(R.menu.main, menu);                                         //
        return true;                                                                          //
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {                                                          //
        int id = item.getItemId();                                                                                 //
        switch (id) {                                                                                               //
            case R.id.action_settings:                                                                               //
                //Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                Intent intent= new Intent(CategoryActivity.this, AddCard.class);
                startActivity(intent);//
                return true;

        }

        ///show back button
        if(item.getItemId()==android.R.id.home)                                                                     ///
        {                                                                                                           ///
            finish();                                                                                               ///
            return super.onOptionsItemSelected(item);                                                               ///
        }                                                                                                          ///
        return true;
    }


    private void getAllItem() {
        Utils.showProgressDialog(this, "Please wait...");
        if (Utils.isInternetConnected(this)) {
            Utils.showProgressDialog(this, "Please wait...");
            RestClient.allItems(new Callback<CategoryResponse>() {
                @Override
                public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

                    Utils.dismissProgressDialog();
                    if (response.body() != null) {
                        if (response.body().getStatus()) {



                            itemList1 = response.body().getCategories();



                            CategoryDashboardAdapter categoryDashboardAdapter = new CategoryDashboardAdapter(getApplicationContext());
                            categoryDashboardAdapter.setdata(itemList1);
                            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(CategoryActivity.this, LinearLayoutManager.VERTICAL, false);
                            recyclerView1.setLayoutManager(linearLayoutManager1);
                            recyclerView1.setAdapter(categoryDashboardAdapter);


                            categoryDashboardAdapter.setSellingListInterface(new CategoryDashboardAdapter.SellingListInterface() {
                                @Override
                                public void sellinglistitem(String id) {
                                    Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                                    intent.putExtra("id", id);
                                    startActivity(intent);

                                }
                            });





                        }
                    }

                }

                @Override
                public void onFailure(Call<CategoryResponse> call, Throwable t) {
                    Toast.makeText(CategoryActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    Utils.dismissProgressDialog();

                }
            });


        }

    }

    public void onResume() {
        super.onResume();
    }



}


