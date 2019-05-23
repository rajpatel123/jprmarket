package com.app.jpr.market.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.jpr.market.Activities.CategoryActivity;
import com.app.jpr.market.R;
import com.app.jpr.market.adapter.DashboardAdapter.CategoryDashboardAdapter;
import com.app.jpr.market.models.CatagoryResponse;
import com.app.jpr.market.models.dashboard.Category;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {
    //private CategoryDashboardAdapter.SellingListInterface sellingListInterface;
    private List<Category> groseryItemList;
    Context context;

    public CourseListAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public CourseListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);

        return new CourseListAdapter.ViewHolder(itemView);
    }

    public void setdata(List<Category> itemList) {
        this.groseryItemList = itemList;
    }


    @Override
    public void onBindViewHolder(@NonNull CourseListAdapter.ViewHolder viewHolder, int i) {

        final Category alllItems = groseryItemList.get(i);
        viewHolder.textView13.setText(alllItems.getCatTitle());
        Picasso.with(context).load(alllItems.getCatImage())
                .error(R.drawable.veg).into(viewHolder.itemImage16);

        viewHolder.textView14.setText(alllItems.getCatDesc());

        viewHolder.textView15.setText(alllItems.getDTitle());

    }

    @Override
    public int getItemCount() {
        return groseryItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemImage16, arrowicon;
        private TextView textView13, textView14, textView15, textView4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView13 = itemView.findViewById(R.id.text_tv11);
            textView14 = itemView.findViewById(R.id.text_tv11);
            textView15 = itemView.findViewById(R.id.text_tv11);
            itemImage16 = itemView.findViewById(R.id.logoID1);
            arrowicon = itemView.findViewById(R.id.arrow);

        }
    }
}
