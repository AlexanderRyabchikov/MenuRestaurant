package com.example.alexander.menurestaurant.Interfaces;

import com.example.alexander.menurestaurant.JsonModel.Menu;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {
    @GET("/api/v1/categories")
    Call<Menu> getMenu();
}
