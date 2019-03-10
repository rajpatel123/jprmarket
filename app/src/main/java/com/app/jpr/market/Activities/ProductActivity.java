package com.app.jpr.market.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.app.jpr.market.R;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;


import android.os.Bundle;
        import android.os.Handler;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
        import java.util.Timer;
        import java.util.TimerTask;

        import me.relex.circleindicator.CircleIndicator;

public class ProductActivity extends AppCompatActivity {

    private TextView info;
    ElegantNumberButton btn;
   // private ElegantNumberButton button;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.veg, R.drawable.vegetable,R.drawable.veg,R.drawable.vegetable,R.drawable.veg};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        init();

        btn = (ElegantNumberButton) findViewById(R.id.mybutton);

        // elegent button
        btn.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=btn.getNumber();
                Log.e("MIN",num);
            }
        });


//         button =  findViewById(R.id.button);
//        button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String num = button.getNumber();
//            }
//        });


        info=findViewById(R.id.infoTV);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ProductActivity.this,InfoActivity.class);
                startActivity(intent);

            }
        });


    }
    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(ProductActivity.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        //Timer swipeTimer = new Timer();
       // swipeTimer.schedule(new TimerTask() {
           // @Override
          //  public void run() {
             //   handler.post(Update);
           // }
        //}, 2500, 2500);
    }

}