package com.app.jpr.market.adapter.mFragment4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter4 extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<>();


    public MyPagerAdapter4(FragmentManager fm) {
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

    public  void  addFragment(Fragment f){
        fragments.add(f);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return ((Fragment4)fragments.get(position)).getTitle();
    }

}
