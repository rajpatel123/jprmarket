package com.app.jpr.market.adapter.mFragment4;

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
import com.app.jpr.market.mFragment3.SubClassChildAdapter3;
import com.app.jpr.market.models.fragmentdatamodel.Product;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SubClassChildAdapter4 extends RecyclerView.Adapter<SubClassChildAdapter4.ViewHolder> {

    private List<Product> subChildItemList4;



    Context context;

    public SubClassChildAdapter4(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclersubcatchildfragmentitem4, viewGroup, false);


        return new SubClassChildAdapter4.ViewHolder(itemView);

    }

    public void setdata(List<Product> itemList) {
        this.subChildItemList4 = itemList;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Product subItems = subChildItemList4.get(i);
        viewHolder.subItemName.setText(subItems.getPTitle());
        Picasso.with(context).load(subItems.getPImage())
                .error(R.drawable.ic_launcher_background).into(viewHolder.subItemimage);

        viewHolder.subItemQuantity.setText(subItems.getPQuantity());

        viewHolder.subChildTotalMoney.setText(subItems.getPPrice());
        viewHolder.subChildDiscountMoney.setText(subItems.getPDiscPrice());

        viewHolder.offButtonMoney.setText(subItems.getDTitle());


    }

    @Override
    public int getItemCount() {
        return subChildItemList4.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView subItemimage;
        TextView nonMember,subItemName,subItemQuantity,subChildTotalMoney,subChildDiscountMoney;
        Button offButtonMoney;
        ElegantNumberButton subchildelegent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            subItemimage= itemView.findViewById(R.id.item_image);
            subItemName = itemView.findViewById(R.id.itemnamesubchild);
            nonMember =itemView.findViewById(R.id.nonmembersubchild);
            subItemQuantity = itemView.findViewById(R.id.ountitysubchild);
            subChildTotalMoney =itemView.findViewById(R.id.totalitemmoneysubchild);
            subChildDiscountMoney =itemView.findViewById(R.id.discountmoneysubchild);
            offButtonMoney =itemView.findViewById(R.id.moneyOff_btnsubchild);
            subchildelegent =itemView.findViewById(R.id.addcartbuttonsubchild);

        }
    }
}
