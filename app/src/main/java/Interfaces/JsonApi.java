package Interfaces;

import JsonModel.Menu;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {
    @GET("categories")
    Call<Menu> getMenu();
}
