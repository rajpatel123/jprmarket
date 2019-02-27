package com.app.jpr.market;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class app_bar_main extends AppCompatActivity {

    Button categorie,serch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        categorie =(Button)findViewById(R.id.categories);
        serch =(Button)findViewById(R.id.serch);


        categorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(app_bar_main.this,categorie.class);
                startActivity(i);
            }
        });


    }
}
