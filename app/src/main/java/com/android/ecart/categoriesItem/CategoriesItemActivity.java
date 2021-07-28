package com.android.ecart.categoriesItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.ecart.R;
import com.android.ecart.dataBase.Item;
import com.android.ecart.finalBill.BillingActivity;
import com.android.ecart.search.SearchActivity;

import java.util.ArrayList;

public class CategoriesItemActivity extends AppCompatActivity implements CategoriesItemContractor.View{

    RecyclerAdapterCategoriesItem recyclerApapterCategoriesItem;
    RecyclerView recyclerView;

    CategoriesItemContractor.Presenter presenter = new CategoriesItemPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_item);
        ImageView ivBill = findViewById(R.id.iv_title_bar_bill);
        ivBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesItemActivity.this, BillingActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.app_title_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoriesItemActivity.this, SearchActivity.class));
            }
        });
        recyclerView = findViewById(R.id.recycler_view_category_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        presenter.attachView(this);
        int position = getIntent().getIntExtra("Position",0);
        presenter.getItemFromDb(position);

    }

    @Override
    public void displayData(ArrayList<Item> items) {
        recyclerView.setAdapter(new RecyclerAdapterCategoriesItem(items,CategoriesItemActivity.this));
    }
}