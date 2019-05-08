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
import com.app.jpr.market.models.CatagoryResponse;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {

    //img
    private Context applicationContext;//
    private List<CatagoryResponse> categoryResponse;

    public CourseListAdapter(Context applicationContext) {
        this.applicationContext = applicationContext;
    }


    public void setData(List<CatagoryResponse> CourseLists) {
        this.categoryResponse = CourseLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

//holder.first.setText(categoryResponse.get(holder.getAdapterPosition()).getCatId());
        holder.first.setText(categoryResponse.get(holder.getAdapterPosition()).getDTitle());
        holder.second.setText(categoryResponse.get(holder.getAdapterPosition()).getCatTitle());
        holder.third.setText(categoryResponse.get(holder.getAdapterPosition()).getCatDesc());



        ////image
        Picasso.with(applicationContext)                                                             //
                .load(categoryResponse.get(holder.getAdapterPosition()).getCatImage())               //
                .error(R.drawable.veg)                                                    //
                .into(holder.imageView);                                                              //


    }

    @Override
    public int getItemCount() {

        if (categoryResponse != null && categoryResponse.size() > 0) {
            return categoryResponse.size();
        } else {
            return 0;
        }
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView first, second, third;

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            first = itemView.findViewById(R.id.text1);
            second = itemView.findViewById(R.id.text2);
            third = itemView.findViewById(R.id.text3);
            imageView = itemView.findViewById(R.id.logoID);  //ImageView


        }
    }


}
