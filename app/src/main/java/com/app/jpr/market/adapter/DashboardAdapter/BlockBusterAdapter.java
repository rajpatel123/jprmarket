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
import com.app.jpr.market.models.dashboard.BlockbusterSaver;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BlockBusterAdapter  extends RecyclerView.Adapter<BlockBusterAdapter.ViewHolder> {
    private List<BlockbusterSaver>blockBusterAdapter;
    Context context;
    private SellingListInterface sellingListInterface1;///

    public BlockBusterAdapter(Context context) {
        this.context = context;
    }  ////



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())   ////
                .inflate(R.layout.recyclerblockbastersale, viewGroup, false);   ////

        return new ViewHolder(itemView);  ////
    }

    public void setdata(List<BlockbusterSaver> itemList) {
        this.blockBusterAdapter = itemList;

    }  ////

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final BlockbusterSaver blockbusterSaver = blockBusterAdapter.get(i);
        viewHolder.itemName1.setText(blockbusterSaver.getPTitle());
        viewHolder.itemWeight1.setText(blockbusterSaver.getPQuantity());
        viewHolder.totalMoney1.setText(blockbusterSaver.getPPrice());
        viewHolder.discountMoney1.setText(blockbusterSaver.getPDiscPrice());

        Picasso.with(context).load(blockbusterSaver.getPImage())
                .error(R.drawable.veg).into(viewHolder.itemImage1);

        // seeall after all data from api
        if (blockbusterSaver.getPDesc().equalsIgnoreCase("See All")) {
            viewHolder.seeall2.setVisibility(View.VISIBLE);
            viewHolder.productdetail2.setVisibility(View.GONE);

            viewHolder.cardview2.setOnClickListener(new View.OnClickListener() { ///
                @Override
                public void onClick(View v) {                                    ///
                    if (sellingListInterface1 != null) {                           ///
                        sellingListInterface1.sellinglistitemSeeAll1(blockbusterSaver.getPId());   ///
                    }                                                              ///
                }                                                                  ///
            });                                                                    ///

        } else {

            viewHolder.seeall2.setVisibility(View.GONE);
            viewHolder.productdetail2.setVisibility(View.VISIBLE);

            viewHolder.cardview2.setOnClickListener(new View.OnClickListener() { ///
                @Override
                public void onClick(View v) {                                    ///
                    if (sellingListInterface1 != null) {                           ///
                        sellingListInterface1.sellinglistitem1(blockbusterSaver.getPId());   ///
                    }                                                              ///
                }                                                                  ///
            });                                                                    ///

        }


    }


    ///click Lisner
    public void setSellingListInterface1(BlockBusterAdapter.SellingListInterface sellingListInterface1) {    ///
        this.sellingListInterface1 = sellingListInterface1;                                 ///
    }

    @Override
    public int getItemCount() {
        return blockBusterAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private Button  moneyOff1;
        private ElegantNumberButton elegantNumberButton;
        private ImageView itemImage1, lock1;
        private TextView itemName1, itemWeight1, totalMoney1, discountMoney1,seeall2;
        private LinearLayout productdetail2;
        private CardView cardview2;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            elegantNumberButton =  itemView.findViewById(R.id.mybutton);
            moneyOff1 = (Button) itemView.findViewById(R.id.moneyOff_btn1);
            itemImage1 = (ImageView) itemView.findViewById(R.id.vegitable_image1);
            lock1 = (ImageView) itemView.findViewById(R.id.lockIMG1);
            itemName1 = (TextView) itemView.findViewById(R.id.itemname1);
            itemWeight1 = (TextView) itemView.findViewById(R.id.quantity1);
            totalMoney1 = (TextView) itemView.findViewById(R.id.totalmoney1);
            discountMoney1 = (TextView) itemView.findViewById(R.id.discountmoney1);

            seeall2 = (TextView) itemView.findViewById(R.id.seeall2);
            cardview2 =  itemView.findViewById(R.id.cardview2);
            productdetail2 = itemView.findViewById(R.id.productdetail2);


        }
    }

    ///click Lisner
    public interface SellingListInterface {       ///
        public void sellinglistitem1(String id);

        public void sellinglistitemSeeAll1(String id);

    }

}
