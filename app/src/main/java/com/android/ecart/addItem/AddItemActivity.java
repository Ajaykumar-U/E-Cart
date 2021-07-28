package com.android.ecart.addItem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.ecart.R;

public class AddItemActivity extends AppCompatActivity implements AddItemContractor.View {

    EditText etName,etPrice,etImageUrl,etCategory;
    Button btnInsert;
    AddItemContractor.Presenter presenter = (AddItemContractor.Presenter) new AddItemPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        etName = findViewById(R.id.etInsertName);
        etPrice = findViewById(R.id.etInsertPrice);
        etCategory = findViewById(R.id.etInsertCategory);
        etImageUrl = findViewById(R.id.etInsertImage);
        presenter.attachView(this);
        btnInsert = findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData() {
        String itemName = etName.getText().toString();
        String itemPrice = etPrice.getText().toString();
        String itemImageUrl = etImageUrl.getText().toString();
        String itemCategory = etCategory.getText().toString();

        if(itemName.isEmpty()){
            etName.setError("Required");
            etName.requestFocus();
            return;
        }

        if(itemPrice.isEmpty()){
            etPrice.setError("Required");
            etPrice.requestFocus();
            return;
        }

        if(itemImageUrl.isEmpty()){
            etImageUrl.setError("Required");
            etImageUrl.requestFocus();
            return;
        }

        if(itemCategory.isEmpty()){
            etCategory.setError("Required");
            etCategory.requestFocus();
            return;
        }

        presenter.getItemInput(itemName,itemPrice,itemImageUrl,itemCategory);
    }

    @Override
    public void closeAddActivity() {
        onBackPressed();
    }

}