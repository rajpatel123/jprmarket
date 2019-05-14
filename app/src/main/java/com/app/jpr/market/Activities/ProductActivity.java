package com.app.jpr.market.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.app.jpr.market.R;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;


import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ProductActivity extends AppCompatActivity {
    private LinearLayout price;


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;


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

        price=findViewById(R.id.priceID);//
        btn = (ElegantNumberButton) findViewById(R.id.mybutton);

        //expendable listview
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });


        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductActivity.this,PriceActivity.class);
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(

                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });


        ///show back button
        if(getSupportActionBar()!=null){                                                                                  ///
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);                                                       ///
            getSupportActionBar().setDisplayShowHomeEnabled(true);                                                       ///

        }

        // elegent button
        btn.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=btn.getNumber();
                Log.e("MIN",num);
            }
        });




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
       // indicator.setFillColor(Color.RED);
       // CircleIndicator.setTabIndicatorColor(Color.RED);
        indicator.setBackgroundDrawable(new ColorDrawable(Color.RED));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drawers, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {                                                          //
        int id = item.getItemId();                                                                                 //
        switch (id) {                                                                                               //
            case R.id.add_card:                                                                               //
                //Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                Intent intent= new Intent(ProductActivity.this,MyCardActivity.class);
                startActivity(intent);//
                return true;

        }

        ///show back button
        if(item.getItemId()==android.R.id.home)                                                                     ///
        {                                                                                                           ///
            finish();                                                                                               ///
            return super.onOptionsItemSelected(item);                                                               ///
        }                                                                                                          ///
        return true;
    }

}