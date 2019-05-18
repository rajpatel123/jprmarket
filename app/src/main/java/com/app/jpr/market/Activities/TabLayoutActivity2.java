package com.app.jpr.market.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.app.jpr.market.R;
import com.app.jpr.market.mFragment2.Fragment2;
import com.app.jpr.market.mFragment2.MyPagerAdapter2;
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

public class TabLayoutActivity2 extends AppCompatActivity {

    ViewPager viewPager1;
    TabLayout tabLayout;
    private String sub_cat_id;
    private final String TAG = TabLayoutActivity2.class.getSimpleName();


    private MyPagerAdapter2 mypagerAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout2);

        if (getIntent().hasExtra("id")) {
            sub_cat_id = getIntent().getStringExtra("id");
        }
        viewPager1 = findViewById(R.id.mViewpager_ID2);

        getAllSubCategoriesNew(sub_cat_id);

        tabLayout = findViewById(R.id.mTab2_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager1);
        tabLayout.setOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener) this);


    }

    private void getAllSubCategoriesNew(String sub_cat_id) {

        SubChildCatRequest subChildCatRequest = new SubChildCatRequest();
        subChildCatRequest.setSubId(sub_cat_id);

        Utils.showProgressDialog(TabLayoutActivity2.this, "Please wait...");
        RestClient.getAllSubCatChilds(subChildCatRequest, new Callback<SubChildCatResponse>() {
            @Override
            public void onResponse(Call<SubChildCatResponse> call, Response<SubChildCatResponse> response) {
                Utils.dismissProgressDialog();

                if (response != null) {
                    addPages(response.body());
                }

            }

            @Override
            public void onFailure(Call<SubChildCatResponse> call, Throwable t) {
                Utils.dismissProgressDialog();
                Log.d(TAG, " Error in sub cat child api" + t.getMessage());

            }
        });
    }

    //view pager
    private void addPages(SubChildCatResponse body) {

        mypagerAdapter2 = new MyPagerAdapter2(this.getSupportFragmentManager());

        for (int i = 0 ; i < body.getSubChildCategories().size(); i++) {

            SubChildCategory subChildCategory = body.getSubChildCategories().get(i);

            mypagerAdapter2.addFragment(Fragment2.init(subChildCategory.getCTitle()));






        }
        viewPager1.setOffscreenPageLimit(body.getSubChildCategories().size());

        viewPager1.setAdapter(mypagerAdapter2);


    }

    public void onTabSelected(TabLayout.Tab tab) {
        viewPager1.setCurrentItem(tab.getPosition());
    }


}
