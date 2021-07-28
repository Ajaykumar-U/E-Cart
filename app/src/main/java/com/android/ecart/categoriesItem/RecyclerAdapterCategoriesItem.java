package com.android.ecart.categoriesItem;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.ecart.R;
import com.android.ecart.dataBase.Item;
import com.android.ecart.dataBase.ItemDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapterCategoriesItem extends RecyclerView.Adapter {
    List<Item> itemsList;
    Context ctx;
    int i;
    int a1,a2;

    public RecyclerAdapterCategoriesItem(List<Item> itemsList, Context ctx) {
        this.itemsList = itemsList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout_categories_itemlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Item item = itemsList.get(position);
        Picasso.get().load(item.getItemImage()).into(holder1.imageView);
        holder1.tvName.setText(item.getItemName());
        holder1.tvPrice.setText("Rs."+item.getItemPrice());
        i=item.getItemQuantity();
        holder1.tvWeight.setText(String.valueOf(i));
        a1 = position;
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName, tvPrice,tvWeight;
        ImageView btnAdd,btnRemove;
        Boolean clicked = false;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivItemImageRecycler1);
            btnAdd = itemView.findViewById(R.id.plus);
            btnRemove = itemView.findViewById(R.id.minus);
            tvName = itemView.findViewById(R.id.tvItemNameRecycler1);
            tvPrice = itemView.findViewById(R.id.tvItemPriceRecycler1);
            tvWeight = itemView.findViewById(R.id.tvWeight1);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i++;
                    String str = String.valueOf(i);
                    class UpdateClass extends AsyncTask<Void,Void,Void> {
                        @Override
                        protected Void doInBackground(Void... voids) {
                            Item item = itemsList.get(getAdapterPosition());
                            String itemName = item.getItemName();
                            int price = item.getItemPrice();
                            int quantity = i;
                            int totalPrice = price*i;
                            ItemDatabase.getItemDatabaseInstance(ctx).itemDao().updatingBill(price,quantity,totalPrice,itemName);
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                        }
                    }
                    UpdateClass updateClass = new UpdateClass();
                    updateClass.execute();
                    tvWeight.setText(str);
                }
            });
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(i>0){
                        i--;
                    }
                    class UpdateClass extends AsyncTask<Void,Void,Void> {
                        @Override
                        protected Void doInBackground(Void... voids) {
                            Item item = itemsList.get(getAdapterPosition());
                            String itemName = item.getItemName();
                            int price = item.getItemPrice();
                            int quantity = i;
                            int totalPrice = price*i;
                            ItemDatabase.getItemDatabaseInstance(ctx).itemDao().updatingBill(price,quantity,totalPrice,itemName);
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                        }
                    }
                    UpdateClass updateClass = new UpdateClass();
                    updateClass.execute();
                    String str = String.valueOf(i);
                    tvWeight.setText(str);
                }
            });
        }
    }
}
