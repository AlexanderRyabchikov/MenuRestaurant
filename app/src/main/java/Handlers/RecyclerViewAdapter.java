package Handlers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.alexander.menurestaurant.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import JsonModel.MainMenu;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private Context context;
    private List<MainMenu> mainMenus;

    public RecyclerViewAdapter(Context context, List<MainMenu> menus){
        this.context = context;
        this.mainMenus = menus;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        RecyclerViewHolders recyclerViewHolders = new RecyclerViewHolders(layoutView);
        return  recyclerViewHolders;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.textView.setText(mainMenus.get(position).getTitleItem());
        Picasso
                .with(context)
                .load(MenuApi.BASE_URL + mainMenus.get(position).getBackroundItemPath())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mainMenus.size() - 1;
    }
}
