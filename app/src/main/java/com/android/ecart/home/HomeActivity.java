package com.android.ecart.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.ecart.R;
import com.android.ecart.categories.CategoryActivity;
import com.android.ecart.categoriesItem.CategoriesItemActivity;
import com.android.ecart.finalBill.BillingActivity;
import com.android.ecart.search.SearchActivity;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayoutHome;
    SliderView sliderView;
    SliderAdapter sliderAdapter;
    RecyclerView recyclerViewHomeCategory;
    ImageView ivBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBill = findViewById(R.id.iv_title_bar_bill);
        ivBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BillingActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.app_title_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SearchActivity.class));
            }
        });

        tabLayoutHome = findViewById(R.id.tab_layout_home);
        tabLayoutHome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                moveToActivity(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                moveToActivity(tab.getPosition());
            }
        });
        sliderView = findViewById(R.id.sliderView);
        String[] sliderDataList = getResources().getStringArray(R.array.scrolling_images_url);
        sliderAdapter = new SliderAdapter(sliderDataList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        recyclerViewHomeCategory = findViewById(R.id.recyclerViewHome);
        recyclerViewHomeCategory.setLayoutManager(new GridLayoutManager(this,3));
        String[] categoryHome = getResources().getStringArray(R.array.top_categories);
        recyclerViewHomeCategory.setAdapter(new RecyclerViewAdapterHome(categoryHome, HomeActivity.this));
    }
    void moveToActivity(int position){
        if(position == 0){
            startActivity(new Intent(HomeActivity.this,CategoryActivity.class));
        }
        else{
            Intent intent = new Intent(HomeActivity.this, CategoriesItemActivity.class);
            intent.putExtra("Position",position);
            startActivity(intent);
        }
    }
}