package com.app.jpr.market.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.app.jpr.market.R;

public class MyCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_card2);

        if(getSupportActionBar()!=null){                                                                                  ///
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);                                                       ///
            getSupportActionBar().setDisplayShowHomeEnabled(true);                                                       ///

        }







    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {                                                          //
        int id = item.getItemId();                                                                                 //
//        switch (id) {                                                                                               //
//            case R.id.action_settings:                                                                               //
//                //Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
//                Intent intent= new Intent(CategoryActivity.this, AddCard.class);
//                startActivity(intent);//
//                return true;
//
//        }

        ///show back button
        if(item.getItemId()==android.R.id.home)                                                                     ///
        {                                                                                                           ///
            finish();                                                                                               ///
            return super.onOptionsItemSelected(item);                                                               ///
        }                                                                                                          ///
        return true;
    }
}
