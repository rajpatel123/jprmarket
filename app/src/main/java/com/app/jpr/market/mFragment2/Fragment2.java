package com.app.jpr.market.mFragment2;

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

import com.app.jpr.market.Activities.TabLayoutActivity;
import com.app.jpr.market.Activities.TabLayoutActivity2;
import com.app.jpr.market.R;
import com.app.jpr.market.adapter.SubClassChildAdapter;
import com.app.jpr.market.adapter.Tablayout2DataAdapter;
import com.app.jpr.market.models.TabViewSubList.TabSubChildCatRequest;
import com.app.jpr.market.models.TabViewSubList.TabViewSubChildCatResponse;
import com.app.jpr.market.models.tablayout2response.Tab2SubChildCatRequest;
import com.app.jpr.market.models.tablayout2response.Tab2SubChildCatResponse;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment2 extends Fragment {
    private String  catid;
    private Tab2SubChildCatResponse tabcatitem3;
    private RecyclerView recyclerViewSubItem2;

    TabLayoutActivity2 activity;
    String title;

    public Fragment2() {

    }

    public static Fragment2 init(String title) {

        Fragment2 fragment2 = new Fragment2();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment2.setArguments(args);
        return fragment2;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (TabLayoutActivity2) getActivity();


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
        View rootView = inflater.inflate(R.layout.activity_fragment1, container, false);
        recyclerViewSubItem2 = rootView.findViewById(R.id.fragment2recycler);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getAllProducts2();

    }

    @Override
    public String toString() {

        return title;
    }

    public void getAllProducts2() {


        Tab2SubChildCatRequest tab2SubChildCatRequest = new Tab2SubChildCatRequest();

        tab2SubChildCatRequest.setCId("2");

        Utils.showProgressDialog(getContext(), "Please wait...");
        if (Utils.isInternetConnected(getContext())) {
            Utils.showProgressDialog(getContext(), "Please wait...");
            RestClient.tab2AllSubChild(tab2SubChildCatRequest, new Callback<Tab2SubChildCatResponse>() {
                @Override
                public void onResponse(Call<Tab2SubChildCatResponse> call, Response<Tab2SubChildCatResponse> response) {

                    Utils.dismissProgressDialog();
                    if (response.body() != null) {

                        if (response.body().getStatus()) {

                            tabcatitem3 = response.body();
                            if (tabcatitem3 != null && tabcatitem3.getProducts().size() > 0) {

                                Tablayout2DataAdapter tablayout2DataAdapter = new Tablayout2DataAdapter(activity.getApplicationContext());

                                tablayout2DataAdapter.setdata(tabcatitem3.getProducts());
                                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                                recyclerViewSubItem2.setLayoutManager(linearLayoutManager1);
                                recyclerViewSubItem2.setAdapter(tablayout2DataAdapter);

                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<Tab2SubChildCatResponse> call, Throwable t) {
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                    Utils.dismissProgressDialog();

                }

            });
        }
    }
}