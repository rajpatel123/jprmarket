package com.app.jpr.market.Activities;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

import com.app.jpr.market.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button=findViewById(R.id.first);
        Button button1=findViewById(R.id.second);

        cardView=findViewById(R.id.cardview);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProductActivity.class));


            }
        });

       // Icon =findViewById(R.id.action_addcart);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CategoryActivity.class));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
            }
        });






        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(MainActivity.this,MyCardActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id==R.id.nav_location){
            Intent intent=new Intent(MainActivity.this, NearbyLocationActivity.class);
            startActivity(intent);
        }

       if (id == R.id.nav_login) {
           Intent intent=new Intent(MainActivity.this, LoginActivity.class);
           startActivity(intent);

        }else  if(id==R.id.nav_myaddress){
           Intent intent=new Intent(MainActivity.this,LoginActivity.class);
           startActivity(intent);

       }else if(id==R.id.nav_myorder){
           Intent intent=new Intent(MainActivity.this,LoginActivity.class);
           startActivity(intent);

       }else if(id==R.id.nav_mycart){
           Intent intent=new Intent(MainActivity.this, MyCardActivity.class);
           startActivity(intent);

       }else if(id==R.id.nav_wallet){
           Intent intent=new Intent(MainActivity.this,LoginActivity.class);
           startActivity(intent);

       }else if(id==R.id.nav_freeitems){
           Intent intent=new Intent(MainActivity.this,LoginActivity.class);
           startActivity(intent);


       }else if(id==R.id.nav_aboutus){
           Intent intent=new Intent(MainActivity.this,About_us.class);
           startActivity(intent);

       }else if(id==R.id.nav_share){
           Intent intent = new Intent(Intent.ACTION_SEND);
           intent.setType("plain/text");
           intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "---" });
           intent.putExtra(Intent.EXTRA_SUBJECT, "---");
           startActivity(Intent.createChooser(intent, "Contact Us!"));
       }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;




    }


}
