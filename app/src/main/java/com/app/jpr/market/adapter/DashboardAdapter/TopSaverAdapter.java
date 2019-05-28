package com.app.jpr.market.adapter.DashboardAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.jpr.market.R;
import com.app.jpr.market.models.dashboard.TodaySaver;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopSaverAdapter extends RecyclerView.Adapter<TopSaverAdapter.ViewHolder> {
    private List<TodaySaver> topSavaerAdapter;
    Context context;
    private CardView cardView;


    //click lisner
   private TopSaverAdapter.SellingListInterface sellingListInterface2;///

    public TopSaverAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_topsaverstoday, viewGroup, false);

        return new TopSaverAdapter.ViewHolder(itemView);
    }

    public void setdata(List<TodaySaver> itemList) {
        this.topSavaerAdapter = itemList;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final TodaySaver todaySaver = topSavaerAdapter.get(i);

        viewHolder.itemName1.setText(todaySaver.getPDiscPrice());
        Picasso.with(context).load(todaySaver.getPImage())
                .error(R.drawable.veg).into(viewHolder.itemImage1);

        viewHolder.discountMoney1.setText(todaySaver.getPQuantity());
        viewHolder.itemWeight1.setText(todaySaver.getPPrice());
        viewHolder.totalMoney1.setText(todaySaver.getPTitle());


        // seeall after all data from api
        if (todaySaver.getPDesc().equalsIgnoreCase("See All")) {
            viewHolder.seeall3.setVisibility(View.VISIBLE);
            viewHolder.productDeatail3.setVisibility(View.GONE);

            viewHolder.cardView3.setOnClickListener(new View.OnClickListener() { ///
                @Override
                public void onClick(View v) {                                    ///
                    if (sellingListInterface2!= null) {                           ///
                        sellingListInterface2.sellinglistitemSeeAll2(todaySaver.getPId());   ///
                    }                                                              ///
                }                                                                  ///
            });                                                                    ///

        } else {

            viewHolder.seeall3.setVisibility(View.GONE);
            viewHolder.productDeatail3.setVisibility(View.VISIBLE);

            viewHolder.cardView3.setOnClickListener(new View.OnClickListener() { ///
                @Override
                public void onClick(View v) {                                    ///
                    if (sellingListInterface2 != null) {                           ///
                        sellingListInterface2.sellinglistitem2(todaySaver.getPId());   ///
                    }                                                              ///
                }                                                                  ///
            });                                                                    ///

        }

    }

    ///click Lisner
    public void setSellingListInterface2(SellingListInterface sellingListInterface2) {    ///
        this.sellingListInterface2 = (SellingListInterface) sellingListInterface2;                                 ///
    }

    @Override
    public int getItemCount() {
        return topSavaerAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ElegantNumberButton elegantNumberButton;
        private Button addCart, moneyOff;
        private ImageView itemImage1, lock;
        private TextView itemName1, itemWeight1, totalMoney1, discountMoney1, seeall3;
        private CardView cardView3;
        private LinearLayout productDeatail3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            elegantNumberButton = itemView.findViewById(R.id.addcartbutton);
            moneyOff = itemView.findViewById(R.id.moneyOff_btn);
            itemImage1 = itemView.findViewById(R.id.item_image1);
            lock = itemView.findViewById(R.id.lockIMG);
            itemName1 = itemView.findViewById(R.id.item_name1);
            seeall3 = itemView.findViewById(R.id.seeall3);
            itemWeight1 = itemView.findViewById(R.id.item_weight1);
            totalMoney1 = itemView.findViewById(R.id.totalitemmoney1);
            discountMoney1 = itemView.findViewById(R.id.afterdiscount1);
            cardView3 = itemView.findViewById(R.id.cardview3);
            productDeatail3= itemView.findViewById(R.id.productDetail13);



        }
    }

    ///click Lisner
    public interface SellingListInterface {       ///
        public void sellinglistitem2(String id);

        public void sellinglistitemSeeAll2(String id);

    }

}
