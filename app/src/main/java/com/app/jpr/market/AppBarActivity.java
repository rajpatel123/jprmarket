package com.app.jpr.market;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class  AppBarActivity extends AppCompatActivity {
    private Button catagory,search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

//        catagory=findViewById(R.id.catagoryBTN);
//        search=findViewById(R.id.searchBTN);
//
//        catagory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent=new Intent(AppBarActivity.this,CatagoryActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent=new Intent(AppBarActivity.this,SearchActivity.class);
//                startActivity(intent);
//            }
//        });



    }
}
