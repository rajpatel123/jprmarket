package com.app.jpr.market.mFragment3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.app.jpr.market.mFragments.Fragment1;

import java.util.ArrayList;

public class MyPagerAdapter3 extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<>();


    public MyPagerAdapter3(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment3 f) {
        fragments.add(f);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        //String title=fragments.get(position).toString();
        return ((Fragment3) fragments.get(position)).getTitle();


    }


}
