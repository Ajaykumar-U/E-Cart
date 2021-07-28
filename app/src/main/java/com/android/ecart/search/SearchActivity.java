package com.android.ecart.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.android.ecart.R;
import com.android.ecart.categoriesItem.RecyclerAdapterCategoriesItem;
import com.android.ecart.dataBase.Item;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchContractor.View{

    SearchView searchView;
    String strEditedText;
    SearchContractor.Presenter presenter = new SearchPresenter();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.recyclerViewSearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        presenter.attachView((SearchContractor.View) this);;
        searchView = findViewById(R.id.searchView);
        searchView.onActionViewExpanded();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            private Handler handler = new Handler();
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.searchItem(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                strEditedText = newText;
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 500);
                return false;
            }
        });
    }
    private final Runnable runnable = new Runnable() {

        @Override
        public void run() {
            if (!strEditedText.isEmpty()) {
                presenter.searchItem(strEditedText);
            }
        }
    };

    @Override
    public void DisplayData(List<Item> itemList) {
        recyclerView.setAdapter(new RecyclerAdapterCategoriesItem(itemList,SearchActivity.this));
    }
}