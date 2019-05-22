package com.app.jpr.market.mFragment3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.jpr.market.Activities.TabLayoutActivity3;
import com.app.jpr.market.R;
import com.app.jpr.market.adapter.SubClassChildAdapter;
import com.app.jpr.market.models.TabSubChildCatRequestNew;
import com.app.jpr.market.models.TabSubChildCatResponseNew;
import com.app.jpr.market.models.fragmentdatamodel.TabSubChildFragment;
import com.app.jpr.market.models.fragmentdatamodel.TabSubChildFragmentRequest;
import com.app.jpr.market.models.tablayoutresponse.TabSubChildCatRequest;
import com.app.jpr.market.models.tablayoutresponse.TabViewSubChildCatResponse;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment3 extends Fragment {

    private String catid;
    private TabSubChildFragment tabcatitem;
    private RecyclerView recyclerViewSubItem1;

    TabLayoutActivity3 activity;
    String title;

    public Fragment3() {

    }

    public static Fragment3 init(String title) {

        Fragment3 fragment3 = new Fragment3();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment3.setArguments(args);
        return fragment3;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (TabLayoutActivity3) getActivity();

    }

    public String getTitle() {
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
        View rootView = inflater.inflate(R.layout.activity_fragment3, container, false);
        recyclerViewSubItem1 = rootView.findViewById(R.id.fragmentrecycler2);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getAllItems();


    }

    @Override
    public String toString() {

        return title;
    }


    public void getAllItems() {


        TabSubChildFragmentRequest tabSubChildCatRequest = new TabSubChildFragmentRequest();

        tabSubChildCatRequest.setCId("2");

        Utils.showProgressDialog(getContext(), "Please wait...");
        if (Utils.isInternetConnected(getContext())) {
            Utils.showProgressDialog(getContext(), "Please wait...");
            RestClient.tabAllSubChildNewFragment(tabSubChildCatRequest, new Callback<TabSubChildFragment>() {
                @Override
                public void onResponse(Call<TabSubChildFragment> call, Response<TabSubChildFragment> response) {

                    Utils.dismissProgressDialog();
                    if (response.body() != null) {

                        if (response.body().getStatus()) {

                            tabcatitem = response.body();
                            if (tabcatitem != null && tabcatitem.getProducts().size() > 0) {

                                SubClassChildAdapter3 subClassChildAdapter = new SubClassChildAdapter3(activity.getApplicationContext());

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
                public void onFailure(Call<TabSubChildFragment> call, Throwable t) {
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                    Utils.dismissProgressDialog();

                }

            });
        }
    }



}
