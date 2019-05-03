package com.app.jpr.market.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.jpr.market.R;

public class BestSellingAdapter extends RecyclerView.Adapter<BestSellingAdapter.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerbestselling_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder ViewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private Button addCart, moneyOff;
        private ImageView itemImage, lock;
        private TextView itemName, itemWeight, totalMoney, discountMoney;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            addCart = (Button) itemView.findViewById(R.id.addcartbutton);
            moneyOff = (Button) itemView.findViewById(R.id.moneyOff_btn);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            lock = (ImageView) itemView.findViewById(R.id.lockIMG);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemWeight = (TextView) itemView.findViewById(R.id.item_weight);
            totalMoney = (TextView) itemView.findViewById(R.id.totalitemmoney);
            discountMoney = (TextView) itemView.findViewById(R.id.afterdiscount);


        }
    }

}
