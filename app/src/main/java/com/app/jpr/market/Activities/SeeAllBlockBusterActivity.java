package com.app.jpr.market.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.app.jpr.market.BlockBusterFragment.BlockBusterFragmentAdapter;
import com.app.jpr.market.BlockBusterFragment.Fragment2;
import com.app.jpr.market.R;
import com.app.jpr.market.mFragments.Fragment1;
import com.app.jpr.market.mFragments.MyPagerAdapter;
import com.app.jpr.market.models.BlockBusterSeeAll.Blockbuster;
import com.app.jpr.market.models.BlockBusterSeeAll.SeeAllBlockBuster;
import com.app.jpr.market.models.subcatchildrequest.SubChildCatRequest;
import com.app.jpr.market.models.subchildcategoryresponse.SubChildCatResponse;
import com.app.jpr.market.models.subchildcategoryresponse.SubChildCategory;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeeAllBlockBusterActivity extends AppCompatActivity  implements TabLayout.OnTabSelectedListener {
    ViewPager viewPager;
    TabLayout tabLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_block_buster);

        viewPager = (ViewPager) findViewById(R.id.mViewpager_ID);
        this.addPages();
        tabLayout = (TabLayout) findViewById(R.id.mTab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);

    }


   private void addPages() {
       BlockBusterFragmentAdapter blockBusterFragmentAdapter = new BlockBusterFragmentAdapter(this.getSupportFragmentManager());

       for(int i=0; i<=9; i++){
           blockBusterFragmentAdapter.addFragment(new Fragment2());
       }

       viewPager.setAdapter(blockBusterFragmentAdapter);
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

    public void TestUpload(){
        int i = 1+1;
    }
}
