package com.app.jpr.market.adapter.OfferAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.jpr.market.R;
import com.app.jpr.market.models.offer.SaveBeyondGrocery;
import com.app.jpr.market.models.offer.SmartBachatClub;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SmartBachatClubAdapter extends RecyclerView.Adapter<SmartBachatClubAdapter.ViewHolder> {

    private List<SmartBachatClub>smartBachatClubAdapter;
    Context context;
    public SmartBachatClubAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public SmartBachatClubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_smartbachatclub, viewGroup, false);

        return new SmartBachatClubAdapter.ViewHolder(itemView);
    }

    public void setdata(List<SmartBachatClub> itemList) {
        this.smartBachatClubAdapter = itemList;
    }

    @Override
    public void onBindViewHolder(@NonNull SmartBachatClubAdapter.ViewHolder viewHolder, int i) {

        final SmartBachatClub allItems = smartBachatClubAdapter.get(i);
        viewHolder.PTitle.setText(allItems.getPTitle());
        Picasso.with(context).load(allItems.getPImage())
                .error(R.drawable.veg).into(viewHolder.PImage);


        viewHolder.PQuantity.setText(allItems.getPQuantity());
        viewHolder.PPrice.setText(allItems.getPPrice());
        viewHolder.PDiscPrice.setText(allItems.getPDiscPrice());


    }

    @Override
    public int getItemCount() {
        return smartBachatClubAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView PImage,imageView2,imageView3,imageView4;
        private TextView PPrice,PDiscPrice,PTitle,PQuantity,textView5;
        private ElegantNumberButton button;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            PImage=itemView.findViewById(R.id.PImage);
            imageView2=itemView.findViewById(R.id.imageView2);
            imageView3=itemView.findViewById(R.id.imageView3);
            imageView4=itemView.findViewById(R.id.imageView4);

            PPrice=itemView.findViewById(R.id.PPrice);
            PDiscPrice=itemView.findViewById(R.id.PDiscPrice);
            PTitle=itemView.findViewById(R.id.PTitle);
            PQuantity=itemView.findViewById(R.id.PQuantity);
            textView5=itemView.findViewById(R.id.textView5);






        }
    }
}
