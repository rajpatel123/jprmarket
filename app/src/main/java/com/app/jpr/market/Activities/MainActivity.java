package com.app.jpr.market.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.jpr.market.R;
import com.app.jpr.market.adapter.DashboardAdapter.BestSellingAdapter;
import com.app.jpr.market.adapter.DashboardAdapter.BlockBusterAdapter;
import com.app.jpr.market.adapter.DashboardAdapter.CategoryDashboardAdapter;
import com.app.jpr.market.adapter.DashboardAdapter.TopSaverAdapter;
import com.app.jpr.market.models.dashboard.BestSelling;
import com.app.jpr.market.models.dashboard.BlockbusterSaver;
import com.app.jpr.market.models.dashboard.Category;
import com.app.jpr.market.models.dashboard.CategoryResponse;
import com.app.jpr.market.models.dashboard.TodaySaver;
import com.app.jpr.market.retrofit.RestClient;
import com.app.jpr.market.utils.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<BestSelling> itemList;
    private List<BlockbusterSaver> itemList1;
    private List<TodaySaver> itemList2;
    private List<Category> itemList3;
    private RecyclerView recyclerView, recyclerView2, recyclerView1, recyclerView3;

    private CardView cardView, cardview_item;
    private Button seeAll, block, saver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.first);
        Button button1 = findViewById(R.id.second);
        recyclerView = findViewById(R.id.recycler_item1);
        recyclerView1 = findViewById(R.id.recycler_item2);
        recyclerView2 = findViewById(R.id.recycler_item3);
        recyclerView3 = findViewById(R.id.recycler_item4);


        //cardview_item = findViewById(R.id.cardview_item);
        cardView = findViewById(R.id.cardview1);
        seeAll = findViewById(R.id.SeeAll_BTN);
        block = findViewById(R.id.Block_btn);
        saver = findViewById(R.id.Savers_btn);


        getAllItem();


    /*    cardview_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeeAllActivity.class);
                startActivity(intent);
            }
        });*/

        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeeAllActivity.class);
                startActivity(intent);
            }
        });


        block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeeAllBlockBusterActivity.class);
                startActivity(intent);
            }
        });

        saver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeeAllTopSaversActivity.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CategoryActivity.class));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
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
            Intent intent = new Intent(MainActivity.this, AddCard.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here
        int id = item.getItemId();

        if (id == R.id.nav_location) {
            Intent intent = new Intent(MainActivity.this, NearbyLocationActivity.class);
            startActivity(intent);
        }

        if (id == R.id.nav_login) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_myaddress) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_myorder) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_mycart) {
            Intent intent = new Intent(MainActivity.this, AddCard.class);
            startActivity(intent);

        } else if (id == R.id.nav_wallet) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_freeitems) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_aboutus) {
            Intent intent = new Intent(MainActivity.this, About_us.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"---"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "---");
            startActivity(Intent.createChooser(intent, "Contact Us!"));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }

    private void getAllItem() {
        Utils.showProgressDialog(this, "Please wait...");
        if (Utils.isInternetConnected(this)) {
            Utils.showProgressDialog(this, "Please wait...");
            RestClient.allItems(new Callback<CategoryResponse>() {
                @Override
                public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

                    Utils.dismissProgressDialog();
                    if (response.body() != null) {
                        if (response.body().getStatus()) {
                            itemList = response.body().getBestSelling();

                            BestSelling bestSelling = new BestSelling();
                            bestSelling.setPTitle("See All");
                            itemList.add(bestSelling);
                            itemList1 = response.body().getBlockbusterSavers();
                            itemList2 = response.body().getTodaySavers();
                            itemList3 = response.body().getCategories();

                            BestSellingAdapter bestSellingAdapter = new BestSellingAdapter(getApplicationContext());
                            bestSellingAdapter.setdata(itemList);
                            Log.d("Main Activity", "Done");
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                            Log.d("Main Activity", "Two");
                            recyclerView.setLayoutManager(linearLayoutManager);
                            Log.d("Main Activity", "Three");
                            recyclerView.setAdapter(bestSellingAdapter);
                            Log.d("Main Activity", "Four");


                            /// click listner
                            bestSellingAdapter.setSellingListInterface(new BestSellingAdapter.SellingListInterface() { ///
                                @Override
                                ///
                                public void sellinglistitem(String id) {
                                    Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                                    intent.putExtra("id", id);
                                    startActivity(intent);
                                }                                                                                        ///

                                @Override
                                public void sellinglistitemSeeAll(String id) {
                                    //open see all activity
                                    Intent intent = new Intent(MainActivity.this, SeeAllActivity.class);
                                    intent.putExtra("id", id);
                                    startActivity(intent);

                                }
                            });


                            BlockBusterAdapter blockBusterAdapter = new BlockBusterAdapter(getApplicationContext());
                            blockBusterAdapter.setdata(itemList1);
                            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                            recyclerView1.setLayoutManager(linearLayoutManager1);
                            recyclerView1.setAdapter(blockBusterAdapter);


                            TopSaverAdapter topSaverAdapter = new TopSaverAdapter(getApplicationContext());
                            topSaverAdapter.setdata(itemList2);
                            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                            recyclerView2.setLayoutManager(linearLayoutManager2);
                            recyclerView2.setAdapter(blockBusterAdapter);
                            Log.d("Main Activity", "Four");


                            CategoryDashboardAdapter categoryDashboardAdapter = new CategoryDashboardAdapter(getApplicationContext());
                            categoryDashboardAdapter.setdata(itemList3);
                            LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                            recyclerView3.setLayoutManager(linearLayoutManager3);
                            recyclerView3.setAdapter(categoryDashboardAdapter);


                            categoryDashboardAdapter.setSellingListInterface(new CategoryDashboardAdapter.SellingListInterface() {
                                @Override
                                public void sellinglistitem(String id) {
                                    Intent intent = new Intent(MainActivity.this, SubCategoryActivity.class);
                                    intent.putExtra("id", id);
                                    startActivity(intent);

                                }
                            });


                        }
                    }

                }

                @Override
                public void onFailure(Call<CategoryResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    Utils.dismissProgressDialog();

                }
            });


        }

    }

    public void onResume() {
        super.onResume();
    }


}
