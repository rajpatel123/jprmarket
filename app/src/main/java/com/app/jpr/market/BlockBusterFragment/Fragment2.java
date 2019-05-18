package com.app.jpr.market.BlockBusterFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.jpr.market.R;


public class Fragment2 extends Fragment {
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_fragment2,container,false);
        return rootView;
    }

    @Override
    public String toString() {
        String title="Fragment:2";
        return title;
    }
}
