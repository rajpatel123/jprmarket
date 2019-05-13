package com.app.jpr.market.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.app.jpr.market.R;
import com.app.jpr.market.adapter.BestSellingAdapter;
import com.app.jpr.market.adapter.BlockBusterAdapter;
import com.app.jpr.market.adapter.CategoryDashboardAdapter;
import com.app.jpr.market.adapter.OfferAdapter.PlanAdapter;
import com.app.jpr.market.adapter.OfferAdapter.SavedBeyondGroceryAdapter;
import com.app.jpr.market.adapter.OfferAdapter.SmartBachatClubAdapter;
import com.app.jpr.market.adapter.TopSaverAdapter;
import com.app.jpr.market.models.dashboard.BestSelling;
import com.app.jpr.market.models.dashboard.CategoryResponse;
import com.app.jpr.market.models.offer.Membership;
import com.app.jpr.market.models.offer.Plan;
import com.app.jpr.market.models.offer.SaveBeyondGrocery;
import com.app.jpr.market.models.offer.SmartBachatClub;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PriceActivity extends AppCompatActivity {
    private List<Plan> itemList;
    private List<SaveBeyondGrocery> itemList1;
    private List<SmartBachatClub> itemList2;
    private List<Plan>itemList3;


    private RecyclerView recyclerView1,recyclerView2,recyclerView3,recyclerView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);

        recyclerView1 = findViewById(R.id.recycler1);
        recyclerView2 = findViewById(R.id.recycler2);
        recyclerView3 = findViewById(R.id.recycler3);
        recyclerView4 = findViewById(R.id.recycler4);

        getAllItems();

    }



    private void getAllItems() {
        Utils.showProgressDialog(this, "Please wait...");
        if (Utils.isInternetConnected(this)) {
            Utils.showProgressDialog(this, "Please wait...");
            RestClient.allDataItemss(new Callback<Membership>() {
                @Override
                public void onResponse(Call<Membership> call, Response<Membership> response) {

                    Utils.dismissProgressDialog();
                    if (response.body() != null) {
                        if (response.body().getStatus()) {
                            itemList = response.body().getPlans();
                            itemList1=response.body().getSaveBeyondGrocery();
                            itemList2=response.body().getSmartBachatClub();
                            itemList3 = response.body().getPlans();


                            PlanAdapter planAdapter = new PlanAdapter(getApplicationContext());
                            planAdapter.setdata(itemList);
                            Log.d("Main Activity", "Done");
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PriceActivity.this,LinearLayoutManager.HORIZONTAL,false);
                            Log.d("Main Activity", "Two");
                            recyclerView1.setLayoutManager(linearLayoutManager);
                            Log.d("Main Activity", "Three");
                            recyclerView1.setAdapter(planAdapter);
                            Log.d("Main Activity", "Four");


                                                                                                            ////


                            SavedBeyondGroceryAdapter savedBeyondGroceryAdapter = new SavedBeyondGroceryAdapter(getApplicationContext());
                            Log.d("Price Activity","first");
                            savedBeyondGroceryAdapter.setdata(itemList1);
                            Log.d("Price Activity","first");
                            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(PriceActivity.this,LinearLayoutManager.HORIZONTAL,false);
                            Log.d("Price Activity","first");
                            recyclerView2.setLayoutManager(linearLayoutManager1);
                            Log.d("Price Activity","first");
                            recyclerView2.setAdapter(savedBeyondGroceryAdapter);
                            Log.d("Price Activity","first");

                            SmartBachatClubAdapter smartBachatClubAdapter = new SmartBachatClubAdapter(getApplicationContext());
                            Log.d("Price Activity","first");
                            smartBachatClubAdapter.setdata(itemList2);
                            Log.d("Price Activity","first");
                            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(PriceActivity.this,LinearLayoutManager.HORIZONTAL,false);
                            Log.d("Price Activity","first");
                            recyclerView3.setLayoutManager(linearLayoutManager2);
                            Log.d("Price Activity","first");
                            recyclerView3.setAdapter(smartBachatClubAdapter);
                            Log.d("Price Activity","first");

                            PlanAdapter planAdapter1 = new PlanAdapter(getApplicationContext());
                            planAdapter1.setdata(itemList3);
                            Log.d("Main Activity", "Done");
                            LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(PriceActivity.this,LinearLayoutManager.HORIZONTAL,false);
                            Log.d("Main Activity", "Two");
                            recyclerView4.setLayoutManager(linearLayoutManager3);
                            Log.d("Main Activity", "Three");
                            recyclerView4.setAdapter(planAdapter);
                            Log.d("Main Activity", "Four");


                        }
                    }

                }

                @Override
                public void onFailure(Call<Membership> call, Throwable t) {
                    Toast.makeText(PriceActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    Utils.dismissProgressDialog();

                }
            });


        }

    }

    public void onResume() {
        super.onResume();

    }
}
