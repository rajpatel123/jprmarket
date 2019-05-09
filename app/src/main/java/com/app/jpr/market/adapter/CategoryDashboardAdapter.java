package com.app.jpr.market.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.jpr.market.R;
import com.app.jpr.market.models.dashboard.BestSelling;
import com.app.jpr.market.models.dashboard.Category;
import com.app.jpr.market.utils.AttandancePrefs;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryDashboardAdapter extends RecyclerView.Adapter<CategoryDashboardAdapter.MyViewHolder> {
    private SellingListInterface sellingListInterface;
    private List<Category> groseryItemList3;
    Context context;

    public CategoryDashboardAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public CategoryDashboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_dashboard_categoryitems, viewGroup, false);

        return new CategoryDashboardAdapter.MyViewHolder(itemView);
    }

    public void setdata(List<Category> itemList) {
        this.groseryItemList3 = itemList;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryDashboardAdapter.MyViewHolder ViewHolder, int position) {
        final Category alllItems = groseryItemList3.get(position);
        ViewHolder.textView13.setText(alllItems.getCatTitle());
        Picasso.with(context).load(alllItems.getCatImage())
                .error(R.drawable.veg).into(ViewHolder.itemImage16);

        ViewHolder.textView14.setText(alllItems.getCatDesc());

        ViewHolder.textView15.setText(alllItems.getDTitle());
       // AttandancePrefs.putInt(context, "cat_id", Integer.parseInt(alllItems.getCatId()));

        ViewHolder.arrowicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sellingListInterface != null) {
                    sellingListInterface.sellinglistitem(alllItems.getCatId());
                }

            }
        });

    }

    public void setSellingListInterface(SellingListInterface sellingListInterface) {

        this.sellingListInterface = sellingListInterface;
    }


    @Override
    public int getItemCount() {
        return groseryItemList3.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemImage16, arrowicon;
        private TextView textView13, textView14, textView15, textView4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView13 = itemView.findViewById(R.id.text_tv11);
            textView14 = itemView.findViewById(R.id.text_tv11);
            textView15 = itemView.findViewById(R.id.text_tv11);
            itemImage16 = itemView.findViewById(R.id.logoID1);
            arrowicon = itemView.findViewById(R.id.arrow);
        }


    }

    public interface SellingListInterface {
        public void sellinglistitem(String id);
    }
}