package com.maulik_shah.ecommercestore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> mProducts;

    public ProductAdapter(List<Product> mProducts) {
        this.mProducts = mProducts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product p = mProducts.get(position);

        Context myContext  = holder.itemView.getContext();

        int resid = myContext.getResources().getIdentifier(p.getProduct_image(), "drawable", myContext.getPackageName());
        holder.imgProduct.setImageResource(resid);
        holder.txtProductName.setText(p.getName());
//        holder.txtProductDesc.setText(p.getDescription());
        holder.txtProductPrice.setText(p.getPrice());
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtProductName, txtProductDesc, txtProductPrice;
        ImageView imgProduct;
        public MyViewHolder(LayoutInflater layoutInflater, ViewGroup parent) {
            super(layoutInflater.inflate(R.layout.activity_product_display, parent, false));
            txtProductName = itemView.findViewById(R.id.txtName);
//            txtProductDesc = itemView.findViewById(R.id.txtProductDesc);
            txtProductPrice = itemView.findViewById(R.id.txtPrice);
            imgProduct = itemView.findViewById(R.id.imgContact);

            itemView.setOnClickListener(this);

        }

        public void onClick(View view) {
            Context c =view.getContext();
            Product passProduct = mProducts.get(getAdapterPosition());
            Intent i = new Intent(c, ProductDetailActivity.class);

            i.putExtra("productName", passProduct.getName());
            i.putExtra("productDescription", passProduct.getDescription());
            i.putExtra("productPrice", passProduct.getPrice());
            i.putExtra("productPic", passProduct.getProduct_image());

            c.startActivity(i);
        }
    }
}
