package com.app.jpr.market.mFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.jpr.market.R;


public class Trending extends Fragment {
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_fragment1,container,false);
        return rootView;
    }

    @Override
    public String toString() {
        String title="Fragment:1";
        return title;
    }
}
