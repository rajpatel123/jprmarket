package com.app.jpr.market.adapter.SeeAllBestSelling;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.jpr.market.R;
import com.app.jpr.market.models.BestSellingSeeAll.BestSellingNew;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SeeAllBestSellingAdapter extends RecyclerView.Adapter<SeeAllBestSellingAdapter.ViewHolder>{
    private List<BestSellingNew>seeAllBestSellingAdapter;
    Context context;
    public SeeAllBestSellingAdapter(Context context) {
        this.context = context;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_seeallbestselling, viewGroup, false);

        return new SeeAllBestSellingAdapter.ViewHolder(itemView);
    }

    public void setdata(List<BestSellingNew> itemList) {
        this.seeAllBestSellingAdapter= itemList;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final BestSellingNew allItems = seeAllBestSellingAdapter.get(i);
        viewHolder.getPTitle.setText(allItems.getPTitle());
        viewHolder.getPDesc.setText(allItems.getPDesc());

        Picasso.with(context).load(allItems.getPImage())
                .error(R.drawable.veg).into(viewHolder.getPImage);

        viewHolder.getPQuantity.setText(allItems.getPQuantity());
        viewHolder.getPPrice.setText(allItems.getPPrice());
        viewHolder.getPDiscPrice.setText(allItems.getPDiscPrice());
    }

    @Override
    public int getItemCount() {
        return seeAllBestSellingAdapter.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ElegantNumberButton elegantNumberButton;
        private Button addCart, moneyOff;
        private ImageView getPImage, offer,lock,nav;
        private TextView getPTitle, getPDesc, getPQuantity, getPPrice,getDTitle,getSubitems,getPDiscPrice,unlockprice;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            elegantNumberButton = itemView.findViewById(R.id.addcartbutton);
            moneyOff=itemView.findViewById(R.id.OfferButton);


            getPImage = itemView.findViewById(R.id.veg);
            offer = itemView.findViewById(R.id.offerimg);
            lock = itemView.findViewById(R.id.lockimg);
            nav = itemView.findViewById(R.id.navimg);

            getPPrice = itemView.findViewById(R.id.PPrice);
            getPDiscPrice=itemView.findViewById(R.id.PDiscPrice);
            getPTitle = itemView.findViewById(R.id.producttitle);
            getPQuantity = itemView.findViewById(R.id.PQuantity);
            getPDesc = itemView.findViewById(R.id.PPrice);
            unlockprice = itemView.findViewById(R.id.unlockprice);




        }
    }
}
