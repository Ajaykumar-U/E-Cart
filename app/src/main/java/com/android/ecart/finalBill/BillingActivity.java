package com.android.ecart.finalBill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.ecart.R;
import com.android.ecart.dataBase.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class BillingActivity extends AppCompatActivity implements BillingContractor.View {

    BillingContractor.Presenter presenter = new BillingPresenter();
    RecyclerView recyclerView;
    FloatingActionButton btnDeleteBill;
    String strBill = "Amount to be paid\n";
    int totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        presenter.attachView(this);
        presenter.getFinalBillData();
        recyclerView = findViewById(R.id.recyclerViewBilling);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        btnDeleteBill=findViewById(R.id.btnDeleteBill);
        btnDeleteBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBillMessage(strBill);
                presenter.removeBillData();
                onBackPressed();
            }
        });
    }

    private void sendBillMessage(String strBill) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        intent.putExtra(Intent.EXTRA_TEXT,strBill);
        if(intent.resolveActivity(getPackageManager())==null){
            Toast.makeText(getApplicationContext(),"Please install Whatsapp first",Toast.LENGTH_LONG).show();
            return;
        }
        startActivity(intent);
    }

    @Override
    public void getFinalDataBill(List<Item> items) {
        for(Item item:items){
            totalBill += item.getItemTotalPrice();
            strBill +="\n"+ item.getItemName()+"\t     "+item.getItemPrice()+"(Rs)"+" X "+item.getItemQuantity()+"(Qty)"+"\t     "+"Rs."+item.getItemPrice()*item.getItemQuantity();
        }
        strBill += "\n\nGrand Total Price: Rs."+String.valueOf(totalBill);
        recyclerView.setAdapter(new RecyclerAdapterBilling(items,BillingActivity.this));
    }
}