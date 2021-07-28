package com.android.ecart.categories;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.android.ecart.updateItem.UpdateActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterCategory extends RecyclerView.Adapter {
    List<Item> itemsList;
    Context ctx;

    public RecyclerViewAdapterCategory(List<Item> itemsList, Context ctx) {
        this.itemsList = itemsList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout_categories_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Item item = itemsList.get(position);
        Picasso.get().load(item.getItemImage()).into(holder1.imageView);
        holder1.tvName.setText(item.getItemName());
        holder1.tvPrice.setText("Rs."+item.getItemPrice());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView tvName, tvPrice;
        Button btnUpdate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivItemImageRecycler);
            btnUpdate = itemView.findViewById(R.id.btnItemSelect);
            tvName = itemView.findViewById(R.id.tvItemNameRecycler);
            tvPrice = itemView.findViewById(R.id.tvItemPriceRecycler);
            itemView.setOnClickListener(this);
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Item item = itemsList.get(getAdapterPosition());
                    Intent intent = new Intent(ctx, UpdateActivity.class);
                    intent.putExtra("item",item);
                    ctx.startActivity(intent);
                }
            });
        }
        @Override
        public void onClick(View v) {
            Item item = itemsList.get(getAdapterPosition());
            Intent intent = new Intent(ctx, UpdateActivity.class);
            intent.putExtra("item",item);
            ctx.startActivity(intent);
        }
    }
}
