package com.app.jpr.market.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.app.jpr.market.R;
import com.app.jpr.market.adapter.mFragment4.Fragment4;
import com.app.jpr.market.adapter.mFragment4.MyPagerAdapter4;
import com.app.jpr.market.mFragments.MyPagerAdapter;
import com.app.jpr.market.models.TabSubChildCatRequestNew;
import com.app.jpr.market.models.TabSubChildCatResponseNew;
import com.app.jpr.market.models.TabSubChildCategoryNew;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabLayoutActivity4 extends AppCompatActivity implements TabLayout.BaseOnTabSelectedListener {


    ViewPager viewPager;
    TabLayout tabLayout;
    private String sub_cat_id="5";
    private final String TAG = TabLayoutActivity4.class.getSimpleName();
    private ImageView arrowimg2;

    private MyPagerAdapter4 pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout4);

        viewPager = findViewById(R.id.mViewpager_ID2);
       arrowimg2 = findViewById(R.id.arrowimg2);


        getAllSubCategoriess( sub_cat_id);

        tabLayout = findViewById(R.id.mTab_ID2);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);

        arrowimg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TabLayoutActivity4.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void getAllSubCategoriess( String sub_cat_id) {

        TabSubChildCatRequestNew tabSubChildCatRequestNew = new TabSubChildCatRequestNew();
        tabSubChildCatRequestNew.setSubId(sub_cat_id);

        Utils.showProgressDialog(TabLayoutActivity4.this, "Please wait...");
        RestClient.tabAllSubChildNew2(tabSubChildCatRequestNew, new Callback<TabSubChildCatResponseNew>() {
            @Override
            public void onResponse(Call<TabSubChildCatResponseNew> call, Response<TabSubChildCatResponseNew> response) {
                Utils.dismissProgressDialog();

                if (response != null) {
                    addPages(response.body());
                }

            }

            @Override
            public void onFailure(Call<TabSubChildCatResponseNew> call, Throwable t) {
                Utils.dismissProgressDialog();
                Log.d(TAG, " Error in sub cat child api" + t.getMessage());

            }
        });
    }

    //view pager
    private void addPages(TabSubChildCatResponseNew body) {

        pagerAdapter = new MyPagerAdapter4(this.getSupportFragmentManager());

        for (int i = 0 ; i < body.getSubChildCategories().size(); i++) {

            TabSubChildCategoryNew tabSubChildCategoryNew = body.getSubChildCategories().get(i);

            pagerAdapter.addFragment(Fragment4.init(tabSubChildCategoryNew.getCTitle()));






        }
        viewPager.setOffscreenPageLimit(body.getSubChildCategories().size());

        viewPager.setAdapter(pagerAdapter);


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
