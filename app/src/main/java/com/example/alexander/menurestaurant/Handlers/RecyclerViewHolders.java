package com.example.alexander.menurestaurant.Handlers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexander.menurestaurant.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder {
    public TextView textView;
    public ImageView imageView;


    public RecyclerViewHolders(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.menuName);
        imageView = itemView.findViewById(R.id.menuImage);
    }
}
