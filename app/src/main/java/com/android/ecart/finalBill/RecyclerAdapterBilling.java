package com.android.ecart.finalBill;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.ecart.R;
import com.android.ecart.dataBase.Item;

import java.util.List;

public class RecyclerAdapterBilling extends RecyclerView.Adapter {
    List<Item> itemsList;
    Context ctx;

    public RecyclerAdapterBilling(List<Item> itemsList, Context ctx) {
        this.itemsList = itemsList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout_billing,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Item item = itemsList.get(position);
        String priceQuantity = "Rs."+item.getItemPrice()+" * "+item.getItemQuantity()+"(Qty)";
        int totalPrice = item.getItemPrice()*item.getItemQuantity();
        holder1.tvPriceQuantity.setText(priceQuantity);
        holder1.tvName.setText(item.getItemName());
        holder1.tvTotalPrice.setText("Rs."+totalPrice);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPriceQuantity,tvTotalPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameBilling);
            tvPriceQuantity = itemView.findViewById(R.id.tvQuantityBilling);
            tvTotalPrice = itemView.findViewById(R.id.tvQuantityTotalBilling);
        }
    }
}
