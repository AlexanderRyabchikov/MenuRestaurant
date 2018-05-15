package com.example.alexander.menurestaurant.Handlers;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

/**
 * Created by skender on 15.05.18.
 */

public class BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    public static void removeShiftedMode(BottomNavigationView bottomNavigationView){
        BottomNavigationMenuView menuView =
                (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            if(menuView.getChildCount() < 6) {
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView itemView
                            = (BottomNavigationItemView) menuView.getChildAt(i);
                    itemView.setShiftingMode(false);
                    itemView.setCheckable(itemView.getItemData().isChecked());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
