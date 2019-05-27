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
import com.app.jpr.market.models.tablayoutresponse.Product;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SubClassChildAdapter  extends RecyclerView.Adapter<SubClassChildAdapter.MyViewHolder> {

    private List<Product> subChildItemList3;

    private SubItemListAdapter.SellingListInterface sellingListInterface;

    Context context;

    public SubClassChildAdapter(Context context) {
        this.context = context;
    }





    @NonNull
    @Override
    public SubClassChildAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_subcatchildfragmentitem, viewGroup, false);


        return new SubClassChildAdapter.MyViewHolder(itemView);
    }

    public void setdata(List<Product> itemList) {
        this.subChildItemList3 = itemList;
    }


    @Override
    public void onBindViewHolder(@NonNull SubClassChildAdapter.MyViewHolder ViewHolder, int position) {

       final Product subItems = subChildItemList3.get(position);
        ViewHolder.subItemName.setText(subItems.getPTitle());
       Picasso.with(context).load(subItems.getPImage())
                .error(R.drawable.veg).into(ViewHolder.subItemimage);

        ViewHolder.subItemQuantity.setText(subItems.getPQuantity());

        ViewHolder.subChildTotalMoney.setText(subItems.getPPrice());
        ViewHolder.subChildDiscountMoney.setText(subItems.getPDiscPrice());

        ViewHolder.offButtonMoney.setText(subItems.getDTitle());



    }

    @Override
    public int getItemCount() {
        return subChildItemList3.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView subItemimage;
        TextView nonMember,subItemName,subItemQuantity,subChildTotalMoney,subChildDiscountMoney;
        Button offButtonMoney;
        ElegantNumberButton subchildelegent;
        public MyViewHolder(@NonNull View itemView) {

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
