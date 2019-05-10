package com.app.jpr.market.adapter.OfferAdapter;

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
import com.app.jpr.market.models.offer.Plan;
import com.app.jpr.market.models.offer.SaveBeyondGrocery;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SavedBeyondGroceryAdapter extends RecyclerView.Adapter<SavedBeyondGroceryAdapter.ViewHolder> {
    private List<SaveBeyondGrocery>savedBeyondGroceryAdapter;
    Context context;


    public SavedBeyondGroceryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_savedbeyondgrosary, viewGroup, false);

        return new ViewHolder(itemView);


    }

    public void setdata(List<SaveBeyondGrocery> itemList) {
        this.savedBeyondGroceryAdapter = itemList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final SaveBeyondGrocery allItems = savedBeyondGroceryAdapter.get(i);
        viewHolder.textView1.setText(allItems.getPTitle());
        Picasso.with(context).load(allItems.getPImage())
                .error(R.drawable.veg).into(viewHolder.imageView1);


        viewHolder.textView3.setText(allItems.getPQuantity());
        viewHolder.textView4.setText(allItems.getPPrice());
        viewHolder.textView2.setText(allItems.getPDiscPrice());

    }

    @Override
    public int getItemCount() {
        return savedBeyondGroceryAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView1,textView2,textView3,textView4,textView5;
        private ElegantNumberButton button;
        private ImageView imageView1,imageView2,imageView3,imageView4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);
            textView4=itemView.findViewById(R.id.textView4);
            textView5=itemView.findViewById(R.id.textView5);

            imageView1=itemView.findViewById(R.id.imageView1);
            imageView2=itemView.findViewById(R.id.imageView2);
            imageView3=itemView.findViewById(R.id.imageView3);
            imageView4=itemView.findViewById(R.id.imageView4);

            button=itemView.findViewById(R.id.button);





        }
    }
}
