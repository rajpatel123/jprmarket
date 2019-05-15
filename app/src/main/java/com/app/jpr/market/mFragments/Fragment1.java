package com.app.jpr.market.mFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.jpr.market.Activities.MainActivity;
import com.app.jpr.market.Activities.SubCategoryActivity;
import com.app.jpr.market.Activities.TabLayoutActivity;
import com.app.jpr.market.R;
import com.app.jpr.market.adapter.SubClassChildAdapter;
import com.app.jpr.market.adapter.SubItemListAdapter;
import com.app.jpr.market.models.TabViewSubList.TabSubChildCatRequest;
import com.app.jpr.market.models.TabViewSubList.TabViewSubChildCatResponse;
import com.app.jpr.market.models.subCategory.SubCatResponse;
import com.app.jpr.market.models.subcatchildrequest.SubChildCatRequest;
import com.app.jpr.market.models.subchildcategoryresponse.SubChildCatResponse;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment1 extends Fragment {
    private String catid;
    private TabViewSubChildCatResponse tabcatitem;
    private RecyclerView recyclerViewSubItem1;

    TabLayoutActivity activity;
    String title;

    public Fragment1() {

    }

    public static Fragment1 init(String title) {
        Fragment1 fragment1 = new Fragment1();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment1.setArguments(args);

        return fragment1;
          }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (TabLayoutActivity) getActivity();


    }

    public String getTitle(){
        return title;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments() != null ? getArguments().getString("title") : title;
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment1, container, false);
        recyclerViewSubItem1 = rootView.findViewById(R.id.fragmentrecycler);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getAllProducts();

    }

    @Override
    public String toString() {

        return title;
    }

    public void getAllProducts() {


        TabSubChildCatRequest tabSubChildCatRequest = new TabSubChildCatRequest();

        tabSubChildCatRequest.setCId("2");

        Utils.showProgressDialog(getContext(), "Please wait...");
        if (Utils.isInternetConnected(getContext())) {
            Utils.showProgressDialog(getContext(), "Please wait...");
            RestClient.tabAllSubChild(tabSubChildCatRequest, new Callback<TabViewSubChildCatResponse>() {
                @Override
                public void onResponse(Call<TabViewSubChildCatResponse> call, Response<TabViewSubChildCatResponse> response) {

                    Utils.dismissProgressDialog();
                    if (response.body() != null) {

                        if (response.body().getStatus()) {

                            tabcatitem = response.body();
                            if (tabcatitem != null && tabcatitem.getProducts().size() > 0) {

                                SubClassChildAdapter subClassChildAdapter = new SubClassChildAdapter(activity.getApplicationContext());

                                subClassChildAdapter.setdata(tabcatitem.getProducts());

                                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                                recyclerViewSubItem1.setLayoutManager(linearLayoutManager1);
                                recyclerViewSubItem1.setAdapter(subClassChildAdapter);

                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<TabViewSubChildCatResponse> call, Throwable t) {
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                    Utils.dismissProgressDialog();

                }

            });
        }
    }
}