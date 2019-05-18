package com.app.jpr.market.mFragment2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class MyPagerAdapter2 extends FragmentPagerAdapter {

    ArrayList <Fragment> fragments = new ArrayList<>();

    public MyPagerAdapter2(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment f)
    {
        fragments.add(f);
    }


    @Override
    public CharSequence getPageTitle(int position) {

        return ((Fragment2)fragments.get(position)).getTitle();
    }
}