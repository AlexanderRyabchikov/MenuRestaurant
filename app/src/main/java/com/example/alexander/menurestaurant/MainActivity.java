package com.example.alexander.menurestaurant;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.alexander.menurestaurant.Handlers.BottomNavigationViewHelper;
import com.example.alexander.menurestaurant.Handlers.RecyclerViewAdapter;
import retrofit2.Call;

import com.example.alexander.menurestaurant.Handlers.MenuApi;
import com.example.alexander.menurestaurant.Interfaces.JsonApi;
import com.example.alexander.menurestaurant.JsonModel.Menu;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    public static final String SEND_STRING = "dummy_string";
    private JsonApi menuApi;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, DummyActivity.class);
        initButton();
        menuApi = MenuApi.getRetrofit().create(JsonApi.class);
        getMenuJson();
    }

    private void getMenuJson() {
        Call<Menu> call = menuApi.getMenu();
        call.enqueue(new Callback<Menu>() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                if(response.isSuccessful()){
                    Menu menus = (Menu) response.body();
                    LinearLayoutManager lLayout;
                    lLayout = new LinearLayoutManager(MainActivity.this);
                    RecyclerView recyclerView = findViewById(R.id.recycler_view);
                    recyclerView.setLayoutManager(lLayout);
                    assert menus != null;
                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), menus.getMainMenuList());
                    recyclerView.setAdapter(recyclerViewAdapter);
                }
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {

            }
        });
    }

    private void initButton() {
        findViewById(R.id.search_item_menu).setOnClickListener(this);
        findViewById(R.id.shopping_basket).setOnClickListener(this);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper.removeShiftedMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.item_menu:
                                MainActivity.this.recreate();
                                break;
                            case R.id.item_promo:
                                intent.putExtra(MainActivity.SEND_STRING, "Promo button");
                                startActivity(intent);
                                break;
                            case R.id.item_bonus:
                                intent.putExtra(MainActivity.SEND_STRING, "Bonus button");
                                startActivity(intent);
                                break;
                            case R.id.item_rental:
                                intent.putExtra(MainActivity.SEND_STRING, "Rental button");
                                startActivity(intent);
                                break;
                            case R.id.item_other:
                                intent.putExtra(MainActivity.SEND_STRING, "Other button");
                                startActivity(intent);
                                break;
                        }
                        return true;
                    }
                }
        );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shopping_basket:
                intent.putExtra(MainActivity.SEND_STRING, "Basket button");
                startActivity(intent);
                break;
        }
    }
}
