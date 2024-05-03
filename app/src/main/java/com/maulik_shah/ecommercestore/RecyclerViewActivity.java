package com.maulik_shah.ecommercestore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView rView;
    RecyclerView.Adapter adapter;

    List<Product> myProductList = new ArrayList<>();
    ProductSingleton pSingleton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        pSingleton = ProductSingleton.getProductSingleton();
        myProductList = pSingleton.getProductList();

        rView = findViewById(R.id.rView);
        adapter = new ProductAdapter(myProductList);
        rView.setLayoutManager(new GridLayoutManager(this,2));
        rView.setAdapter(adapter);
    }
}