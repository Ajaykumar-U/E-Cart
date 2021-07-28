package com.android.ecart.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.ecart.R;
import com.android.ecart.categories.CategoryActivity;
import com.android.ecart.categoriesItem.CategoriesItemActivity;
import com.squareup.picasso.Picasso;

public class RecyclerViewAdapterHome extends RecyclerView.Adapter {
    String[] imageCategory;
    Context ctx;
    public RecyclerViewAdapterHome(String[] imageCategory, Context ctx) {
        this.imageCategory = imageCategory;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout_home_categories,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Picasso.get().load(imageCategory[position]).into(holder1.ivCategory);
    }

    @Override
    public int getItemCount() {
        return imageCategory.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivCategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCategory = itemView.findViewById(R.id.ivHomeCategory);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = getAdapterPosition() + 10;
            Intent intent = new Intent(ctx, CategoriesItemActivity.class);
            intent.putExtra("Position",id);
            ctx.startActivity(intent);
        }
    }
}
