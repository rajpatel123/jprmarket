package com.app.jpr.market.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.jpr.market.R;
import com.app.jpr.market.models.SubcategoryResponse;
import com.app.jpr.market.models.dashboard.BestSelling;
import com.app.jpr.market.models.subCategory.SubCatResponse;
import com.app.jpr.market.models.subCategory.SubCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SubItemListAdapter extends RecyclerView.Adapter<SubItemListAdapter.MyViewHolder> {
    private List<SubCategory> SubItemList;
    Context context;
    public SubItemListAdapter(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public SubItemListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_subitemcategory, viewGroup, false);
        return new SubItemListAdapter.MyViewHolder(itemView);

    }
    public void setdata(List<SubCategory> itemList) {
        this.SubItemList = itemList;
    }



    @Override
    public void onBindViewHolder(@NonNull SubItemListAdapter.MyViewHolder ViewHolder, int position) {
        SubCategory subitems = SubItemList.get(position);
        ViewHolder.subcattitle.setText(subitems.getSubTitle());
        Picasso.with(context).load(subitems.getSubImage())
                .error(R.drawable.veg).into(ViewHolder.subcatimage);

        ViewHolder.subcatdiscount.setText(subitems.getDTitle());
       
    }

    @Override


    public int getItemCount() {
        return SubItemList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView subcatimage;
        private TextView  subcattitle,subcatdiscount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            subcatimage = itemView.findViewById(R.id.subcat_image);
            subcatdiscount = itemView.findViewById(R.id.subcat_discount);
            subcattitle = itemView.findViewById(R.id.subcat_itemname);
        }
    }
}
