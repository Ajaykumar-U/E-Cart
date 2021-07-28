package com.android.ecart.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.ecart.R;
import com.android.ecart.addItem.AddItemActivity;
import com.android.ecart.categoriesItem.CategoriesItemActivity;
import com.android.ecart.dataBase.Item;
import com.android.ecart.finalBill.BillingActivity;
import com.android.ecart.home.HomeActivity;
import com.android.ecart.search.SearchActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements CategoryContractor.View {

    RecyclerView recyclerView;
    CategoryContractor.Presenter presenter = new CategoryPresenter();
    FloatingActionButton fabAddItem;
    Button btnCategoryFruits,btnCategoryVegetables,btnCategoryInstantFoods,btnCategoryDairy,btnCategorySnacks,
            btnCategoryBeverages,btnCategoryBeautyCare,btnCategoryHomeHygiene,btnCategoryBaby,btnCategoryMen,
            btnCategoryWomen,btnCategoryKids,btnCategoryGrocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ImageView ivBill = findViewById(R.id.iv_title_bar_bill);
        ivBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, BillingActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.app_title_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, SearchActivity.class));
            }
        });
        btnCategoryGrocery = findViewById(R.id.btnCategoryGrocery);
        btnCategoryGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Grocery");
            }
        });
        btnCategoryFruits = findViewById(R.id.btnCategoryFruits);
        btnCategoryFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Fruits");
            }
        });
        btnCategoryVegetables = findViewById(R.id.btnCategoryVegetables);
        btnCategoryVegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Vegetables");
            }
        });
        btnCategoryInstantFoods = findViewById(R.id.btnCategoryInstantFoods);
        btnCategoryInstantFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Instant Food");
            }
        });
        btnCategoryDairy = findViewById(R.id.btnCategoryDairy);
        btnCategoryDairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Dairy");
            }
        });
        btnCategoryBeverages = findViewById(R.id.btnCategoryBeverages);
        btnCategoryBeverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Beverages");
            }
        });
        btnCategoryBeautyCare = findViewById(R.id.btnCategoryBeautyCare);
        btnCategoryBeautyCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Beauty Care");
            }
        });
        btnCategoryHomeHygiene = findViewById(R.id.btnCategoryHomeHygiene);
        btnCategoryHomeHygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Home Hygiene");
            }
        });
        btnCategoryBaby = findViewById(R.id.btnCategoryBaby);
        btnCategoryBaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Baby Care");
            }
        });
        btnCategoryMen = findViewById(R.id.btnCategoryMen);
        btnCategoryMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Mens Wear");
            }
        });
        btnCategorySnacks = findViewById(R.id.btnCategorySnacks);
        btnCategorySnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Snacks");
            }
        });
        btnCategoryWomen = findViewById(R.id.btnCategoryWomen);
        btnCategoryWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Womens Wear");
            }
        });
        btnCategoryKids = findViewById(R.id.btnCategoryKids);
        btnCategoryKids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getItemBasedCategory("Kids Wear");
            }
        });
        presenter.attachView(this);
        presenter.getItemFromDb();
        fabAddItem = findViewById(R.id.fabAddItem);
        fabAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, AddItemActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recyclerViewCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    public void displayData(ArrayList<Item> items) {
        recyclerView.setAdapter(new RecyclerViewAdapterCategory(items,CategoryActivity.this));
    }
}