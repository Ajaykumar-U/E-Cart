package com.android.ecart.updateItem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.ecart.R;
import com.android.ecart.dataBase.Item;

public class UpdateActivity extends AppCompatActivity implements UpdateContractor.View{

    EditText etUpdateName,etUpdatePrice,etUpdateImage,etUpdateCategory;
    Button btnDelete,btnUpdate;

    UpdateContractor.Presenter presenter = new UpdatePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etUpdateName = findViewById(R.id.etUpdateName);
        etUpdatePrice = findViewById(R.id.etUpdatePrice);
        etUpdateImage = findViewById(R.id.etUpdateImage);
        etUpdateCategory = findViewById(R.id.etUpdateCategory);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        presenter.setView(this);
        Item itemDb = (Item) getIntent().getSerializableExtra("item");
        showDataToUpdate(itemDb);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData(itemDb);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData(itemDb);
            }
        });
    }

    private void showDataToUpdate(Item itemDb) {
        etUpdateName.setText(itemDb.getItemName());
        etUpdateImage.setText(itemDb.getItemImage());
        etUpdatePrice.setText(String.valueOf(itemDb.getItemPrice()));
        etUpdateCategory.setText(itemDb.getItemCategory());
    }

    private void deleteData(Item itemDb) {
        presenter.deleteItem(itemDb);
    }

    private void updateData(Item itemDb) {
        String name = etUpdateName.getText().toString();
        String price = etUpdatePrice.getText().toString();
        String image = etUpdateImage.getText().toString();
        String category =  etUpdateCategory.getText().toString();
        if(name.isEmpty()){
            etUpdateName.setError("Required");
            etUpdateName.requestFocus();
            return;
        }

        if(price.isEmpty()){
            etUpdatePrice.setError("Required");
            etUpdatePrice.requestFocus();
            return;
        }

        if(image.isEmpty()){
            etUpdateImage.setError("Required");
            etUpdateImage.requestFocus();
            return;
        }

        if(category.isEmpty()){
            etUpdateCategory.setError("Required");
            etUpdateCategory.requestFocus();
            return;
        }
        presenter.getShoppingItem(name,price,category,image,itemDb);
    }

    @Override
    public void closeActivity() {
        onBackPressed();
    }
}