package com.app.jpr.market.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.jpr.market.R;

public class MyCardActivity extends AppCompatActivity {
    private Button shopping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_card);

        shopping=findViewById(R.id.enter_BTN);

        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyCardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
