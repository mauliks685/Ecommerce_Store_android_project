package com.maulik_shah.ecommercestore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    TextView txtProductName, txtProductDesc, txtProductPrice;
    ImageView imgContactFull;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        txtProductName = findViewById(R.id.txtProductName);
        txtProductPrice = findViewById(R.id.txtPrice);
        txtProductDesc = findViewById(R.id.txtProductDesc);
        imgContactFull = findViewById(R.id.imgLarger);

        Intent i = getIntent();
        String name = i.getStringExtra("productName");
        String price = i.getStringExtra("productPrice");
        String desc = i.getStringExtra("productDescription");
        String photo = i.getStringExtra("productPic");

        txtProductName.setText(name);
        txtProductPrice.setText(price);
        txtProductDesc.setText(desc);

        int resid = getResources().getIdentifier(photo, "drawable", getPackageName());
        imgContactFull.setImageResource(resid);
    }

    public void checkout(View view) {
        startActivity(new Intent(ProductDetailActivity.this, CheckoutActivity.class));
    }
}