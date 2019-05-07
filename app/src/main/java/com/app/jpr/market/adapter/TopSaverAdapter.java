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
import com.app.jpr.market.models.dashboard.TodaySaver;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.List;

public class TopSaverAdapter extends RecyclerView.Adapter<TopSaverAdapter.MyViewHolder> {
    private List<TodaySaver> groseryItemList2;
    Context context;
    public TopSaverAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclertopsaverstoday, viewGroup, false);

        return new MyViewHolder(itemView);

    }
    public void setdata(List<TodaySaver> itemList) {

        this.groseryItemList2 = itemList;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return groseryItemList2.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private Button moneyOff2;
        private ElegantNumberButton elegantNumberButton3;
        private ImageView itemImage2, lock2;
        private TextView itemName2, itemWeight2, totalMoney2, discountMoney2;



        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            elegantNumberButton3 =  itemView.findViewById(R.id.mybutton3);
            moneyOff2 =  itemView.findViewById(R.id.moneyOff_btn2);
            itemImage2 =  itemView.findViewById(R.id.vegitable_image2);
            lock2 =  itemView.findViewById(R.id.lockIMG3);
            itemName2 =  itemView.findViewById(R.id.itemname2);
            itemWeight2 =  itemView.findViewById(R.id.itemquantity2);
            totalMoney2 =  itemView.findViewById(R.id.totalitemmoney2);
            discountMoney2 =  itemView.findViewById(R.id.discountmoney2);

        }


    }
}
