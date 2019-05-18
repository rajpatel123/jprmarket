package com.app.jpr.market.BlockBusterFragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.jpr.market.mFragments.Fragment1;

import java.util.ArrayList;

public class BlockBusterFragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments=new ArrayList<>();


    public BlockBusterFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return  fragments.size();
    }

    public void addFragment(Fragment f)
    {
        fragments.add(f);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title=fragments.get(position).toString();
        return title.toString();
    }

}
