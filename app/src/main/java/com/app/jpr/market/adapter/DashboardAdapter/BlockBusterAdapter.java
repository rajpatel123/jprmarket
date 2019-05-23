package com.app.jpr.market.adapter.DashboardAdapter;

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
import com.app.jpr.market.models.dashboard.BlockbusterSaver;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BlockBusterAdapter  extends RecyclerView.Adapter<BlockBusterAdapter.MyViewHolder> {

    private List<BlockbusterSaver> groseryItemList1;
    Context context;

   /* //click lisner
    private SellingListInterface sellingListInterface;///*/

    public BlockBusterAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.recyclerblockbastersale, viewGroup, false);

        return new MyViewHolder(itemView);

    }
    public void setdata(List<BlockbusterSaver> itemList) {
        this.groseryItemList1 = itemList;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder ViewHolder, int position) {

        final BlockbusterSaver alItems = groseryItemList1.get(position);
        ViewHolder.itemName1.setText(alItems.getPTitle());
        Picasso.with(context).load(alItems.getPImage())
                .error(R.drawable.veg).into(ViewHolder.itemImage1);

        ViewHolder.itemWeight1.setText(alItems.getPQuantity());
        ViewHolder.totalMoney1.setText(alItems.getPPrice());
        ViewHolder.discountMoney1.setText(alItems.getPDiscPrice());


      /*  // seeall after all data from api
        if (alItems.getPTitle().equalsIgnoreCase("See All")) {
            ViewHolder.seeall.setVisibility(View.VISIBLE);
            ViewHolder.productDeatail.setVisibility(View.GONE);

            ViewHolder.cardView.setOnClickListener(new View.OnClickListener() { ///
                @Override
                public void onClick(View v) {                                    ///
                    if (sellingListInterface != null) {                           ///
                        sellingListInterface.sellinglistitemSeeAll(alItems.getPId());   ///
                    }                                                              ///
                }                                                                  ///
            });                                                                    ///

        } else {

            viewHolder.seeall.setVisibility(View.GONE);
            viewHolder.productDeatail.setVisibility(View.VISIBLE);

            iewHolder.cardView.setOnClickListener(new View.OnClickListener() { ///
                @Override
                public void onClick(View v) {                                    ///
                    if (sellingListInterface != null) {                           ///
                        sellingListInterface.sellinglistitem(alItems.getPId());   ///
                    }                                                              ///
                }                                                                  ///
            });                                                                    ///

        }*/

    }

/*
    ///click Lisner
    public void setSellingListInterface(BestSellingAdapter.SellingListInterface sellingListInterface) {    ///
        this.sellingListInterface = sellingListInterface;                                 ///
    }  */                                                                                   ///

    @Override
    public int getItemCount() {
        return groseryItemList1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private Button  moneyOff1;
        private ElegantNumberButton elegantNumberButton;
        private ImageView itemImage1, lock1;
        private TextView itemName1, itemWeight1, totalMoney1, discountMoney1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            elegantNumberButton =  itemView.findViewById(R.id.mybutton);
            moneyOff1 = (Button) itemView.findViewById(R.id.moneyOff_btn1);
            itemImage1 = (ImageView) itemView.findViewById(R.id.vegitable_image1);
            lock1 = (ImageView) itemView.findViewById(R.id.lockIMG1);
            itemName1 = (TextView) itemView.findViewById(R.id.itemname1);
            itemWeight1 = (TextView) itemView.findViewById(R.id.quantity1);
            totalMoney1 = (TextView) itemView.findViewById(R.id.totalmoney1);
            discountMoney1 = (TextView) itemView.findViewById(R.id.discountmoney1);

        }
    }

  /*  ///click Lisner
    public interface SellingListInterface {       ///
        public void sellinglistitem(String id);

        public void sellinglistitemSeeAll(String id);

    }*/

}
