package com.example.alexander.menurestaurant.Handlers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.alexander.menurestaurant.JsonModel.MainMenu;

public class CustomAdapterMenu extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<MainMenu> mainMenus;
    TextView textView;
    MainMenu menu;
    View view;
    ImageView imageView;
    public CustomAdapterMenu(Context ctx, List<MainMenu> menus){
        context = ctx;
        mainMenus = menus;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mainMenus.size();
    }

    @Override
    public MainMenu getItem(int i) {
        return mainMenus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mainMenus.get(i).get_id();
    }
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        view = convertView;
        /*if (view == null){
            view = inflater.inflate(R.layout.item_list, viewGroup, false);
        }
        menu = getItem(i);
        textView = view.findViewById(R.id.item_text);
        imageView = view.findViewById(R.id.imageView);
        textView.setText(menu.getTitleItem());
        Picasso
                .with(context)
                .load(MenuApi.BASE_URL + menu.getBackroundItemPath())
                .into(imageView);*/
        return view;
     }


    public void remove(int position){
        mainMenus.remove(getItem(position));
    }
}
