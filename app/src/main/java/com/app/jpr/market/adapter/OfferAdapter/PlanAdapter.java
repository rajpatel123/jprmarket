
package com.app.jpr.market.adapter.OfferAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.jpr.market.R;
import com.app.jpr.market.adapter.BestSellingAdapter;
import com.app.jpr.market.models.dashboard.BestSelling;
import com.app.jpr.market.models.offer.Plan;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {
    private List<Plan>planAdapter;
    Context context;

    public PlanAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyler_plan, viewGroup, false);

        return new ViewHolder(itemView);

    }

    public void setdata(List<Plan> itemList) {
        this.planAdapter = itemList;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        final Plan allItems = planAdapter.get(i);
        viewHolder.PlanMonths.setText(allItems.getPlanMonths());
        viewHolder.PlanPrice.setText(allItems.getPlanPrice());
        viewHolder.PlanDiscountPrice.setText(allItems.getPlanDiscountPrice());
        viewHolder.PlanFree.setText(allItems.getPlanFree());


    }

    @Override
    public int getItemCount() {
        return planAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button button;
        private TextView PlanMonths,PlanPrice,PlanDiscountPrice,PlanFree,textView5,textView6;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            button= itemView.findViewById(R.id.button);
            PlanMonths= itemView.findViewById(R.id.PlanMonths);
            PlanPrice= itemView.findViewById(R.id.PlanPrice);
            PlanDiscountPrice= itemView.findViewById(R.id.PlanDiscountPrice);
            PlanFree= itemView.findViewById(R.id.PlanFree);
            textView5= itemView.findViewById(R.id.textView5);
            textView6= itemView.findViewById(R.id.textView6);


        }
    }
}

