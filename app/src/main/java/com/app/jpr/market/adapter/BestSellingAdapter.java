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
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BestSellingAdapter extends RecyclerView.Adapter<BestSellingAdapter.MyViewHolder> {
    private List<BestSelling> groseryItemList;
    Context context;
    public BestSellingAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerbestselling_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    public void setdata(List<BestSelling> itemList) {
        this.groseryItemList = itemList;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder ViewHolder,  int position ) {
       BestSelling allItems = groseryItemList.get(position);
       ViewHolder.itemName.setText(allItems.getPTitle());
       Picasso.with(context).load(allItems.getPImage())
               .error(R.drawable.veg).into(ViewHolder.itemImage);

       ViewHolder.itemWeight.setText(allItems.getPQuantity());
       ViewHolder.totalMoney.setText(allItems.getPPrice());
       ViewHolder.discountMoney.setText(allItems.getPDiscPrice());



    }

    @Override
    public int getItemCount() {
        return groseryItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private ElegantNumberButton elegantNumberButton;
        private Button addCart, moneyOff;
        private ImageView itemImage, lock;
        private TextView itemName, itemWeight, totalMoney, discountMoney;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            elegantNumberButton =  itemView.findViewById(R.id.addcartbutton);
            moneyOff =  itemView.findViewById(R.id.moneyOff_btn);
            itemImage =  itemView.findViewById(R.id.item_image);
            lock =  itemView.findViewById(R.id.lockIMG);
            itemName =  itemView.findViewById(R.id.item_name);
            itemWeight =  itemView.findViewById(R.id.item_weight);
            totalMoney =  itemView.findViewById(R.id.totalitemmoney);
            discountMoney =  itemView.findViewById(R.id.afterdiscount);


        }

    }

}
