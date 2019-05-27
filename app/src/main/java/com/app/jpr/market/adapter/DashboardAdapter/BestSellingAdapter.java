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
import com.app.jpr.market.models.dashboard.BestSelling;
import com.app.jpr.market.utils.Utils;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BestSellingAdapter extends RecyclerView.Adapter<BestSellingAdapter.MyViewHolder> {
    private List<BestSelling> bestSellingAdapter;
    Context context;
    private CardView cardView;

    //click lisner
    private SellingListInterface sellingListInterface;///

    public BestSellingAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_bestsellingitems, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    public void setdata(List<BestSelling> itemList) {
        this.bestSellingAdapter = itemList;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        final BestSelling bestSelling = bestSellingAdapter.get(position);

        viewHolder.itemName.setText(bestSelling.getPTitle());

        Picasso.with(context).load(bestSelling.getPImage())
                             .error(R.drawable.veg)
                             .into(viewHolder.itemImage);

        viewHolder.itemWeight.setText(bestSelling.getPQuantity());
        viewHolder.totalMoney.setText(bestSelling.getPPrice());
        viewHolder.discountMoney.setText(bestSelling.getPDiscPrice());
        // seeall after all data from api
        if (bestSelling.getPTitle().equalsIgnoreCase("See All")) {
            viewHolder.seeall.setVisibility(View.VISIBLE);
            viewHolder.productDeatail.setVisibility(View.GONE);

            viewHolder.cardView.setOnClickListener(new View.OnClickListener() { ///
                @Override
                public void onClick(View v) {                                    ///
                    if (sellingListInterface != null) {                           ///
                        sellingListInterface.sellinglistitemSeeAll(bestSelling.getPId());   ///
                    }                                                              ///
                }                                                                  ///
            });                                                                    ///

        } else {

            viewHolder.seeall.setVisibility(View.GONE);
            viewHolder.productDeatail.setVisibility(View.VISIBLE);

            viewHolder.cardView.setOnClickListener(new View.OnClickListener() { ///
                @Override
                public void onClick(View v) {                                    ///
                    if (sellingListInterface != null) {                           ///
                        sellingListInterface.sellinglistitem(bestSelling.getPId());   ///
                    }                                                              ///
                }                                                                  ///
            });                                                                    ///

        }
    }

    ///click Lisner
    public void setSellingListInterface(SellingListInterface sellingListInterface) {    ///
        this.sellingListInterface = sellingListInterface;                                 ///
    }                                                                                     ///


    @Override
    public int getItemCount() {
        return bestSellingAdapter.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private ElegantNumberButton elegantNumberButton;
        private Button addCart, moneyOff;
        private ImageView itemImage, lock;
        private TextView itemName, itemWeight, totalMoney, discountMoney, seeall;
        private CardView cardView;
        private LinearLayout productDeatail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            elegantNumberButton = itemView.findViewById(R.id.addcartbutton);
            moneyOff = itemView.findViewById(R.id.moneyOff_btn);
            itemImage = itemView.findViewById(R.id.item_image);
            lock = itemView.findViewById(R.id.lockIMG);
            itemName = itemView.findViewById(R.id.item_name);
            seeall = itemView.findViewById(R.id.seeall);
            itemWeight = itemView.findViewById(R.id.item_weight);
            totalMoney = itemView.findViewById(R.id.totalitemmoney);
            discountMoney = itemView.findViewById(R.id.afterdiscount);
            cardView = itemView.findViewById(R.id.cardview1);
            productDeatail = itemView.findViewById(R.id.productDetail1);


        }

    }

    ///click Lisner
    public interface SellingListInterface {       ///
        public void sellinglistitem(String id);

        public void sellinglistitemSeeAll(String id);

    }                                             ///

}
