package com.app.jpr.market.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.app.jpr.market.R;
import com.app.jpr.market.mFragments.Fragment1;
import com.app.jpr.market.mFragments.MyPagerAdapter;
import com.app.jpr.market.models.subcatchildrequest.SubChildCatRequest;
import com.app.jpr.market.models.subchildcategoryresponse.SubChildCatResponse;
import com.app.jpr.market.models.subchildcategoryresponse.SubChildCategory;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TabLayoutActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    ViewPager viewPager;
    TabLayout tabLayout;
    private String sub_cat_id;
    private  final String TAG = TabLayoutActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        if (getIntent().hasExtra("id")) {
            sub_cat_id = getIntent().getStringExtra("id");
        }
        viewPager = findViewById(R.id.mViewpager_ID);

        getAllSubCategories(sub_cat_id);
        tabLayout = findViewById(R.id.mTab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);


    }

    private void getAllSubCategories(String sub_cat_id) {

        SubChildCatRequest subChildCatRequest = new SubChildCatRequest();
        subChildCatRequest.setSubId(sub_cat_id);

        Utils.showProgressDialog(TabLayoutActivity.this, "Please wait...");
        RestClient.getAllSubCatChilds(subChildCatRequest, new Callback<SubChildCatResponse>() {
            @Override
            public void onResponse(Call<SubChildCatResponse> call, Response<SubChildCatResponse> response) {
                Utils.dismissProgressDialog();
                if (response!=null){
                    addPages(response.body());
                }

            }

            @Override
            public void onFailure(Call<SubChildCatResponse> call, Throwable t) {
                Utils.dismissProgressDialog();
                Log.d(TAG," Error in sub cat child api"+t.getMessage());

            }
        });
    }

    private void addPages(SubChildCatResponse body) {
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(this.getSupportFragmentManager());
        for (int i = 0; i <body.getSubChildCategories().size(); i++) {
            SubChildCategory subChildCategory = body.getSubChildCategories().get(i);

            pagerAdapter.addFragment(new Fragment1().init(this,subChildCategory.getCTitle()));
        }

        viewPager.setAdapter(pagerAdapter);
    }

    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }


    public void TestUpload() {
        int i = 1 + 1;
    }
}
