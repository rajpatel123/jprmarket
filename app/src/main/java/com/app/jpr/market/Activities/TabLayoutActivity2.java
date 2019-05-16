package com.app.jpr.market.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.jpr.market.R;

public class TabLayoutActivity2 extends AppCompatActivity {

    private ViewPager viewPager2;
    private TabLayout tabLayout2;
    private String category_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout2);

    }
}
