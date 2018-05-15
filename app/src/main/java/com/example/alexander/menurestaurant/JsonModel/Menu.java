package com.example.alexander.menurestaurant.JsonModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Menu {
    public List<MainMenu> getMainMenuList() {
        return mainMenuList;
    }

    @SerializedName("data")
    private List<MainMenu> mainMenuList;
}
