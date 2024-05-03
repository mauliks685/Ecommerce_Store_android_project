package com.maulik_shah.ecommercestore;

import java.util.ArrayList;
import java.util.List;

public class ProductSingleton {
    private final List<Product> mProductList =new ArrayList<>();
    private static ProductSingleton mProductSingleton;
    public static ProductSingleton getProductSingleton(){
        if(mProductSingleton == null) {
            mProductSingleton = new ProductSingleton();
        }
        return mProductSingleton;
    }

    private ProductSingleton(){
        Product p1 = new Product("Nike Running Shoes", "We didn't invent the remix—but considering the material we get to sample, this one's a no-brainer. We fired up the SP-12 and took elements from the AJ6, 7 and 8, making them into a completely new shoe that celebrates MJ's first 3-peat championship run.\n With leather, textile and nubuck details, these sneakers honour one legacy while encouraging you to cement your own.", "shoes1", "255");
        Product p2 = new Product("Nike Running Shoes", "Unisex Shoes, Running shoes", "shoes2", "255");
        Product p3 = new Product("Nike Running Shoes", "Unisex Shoes, Running shoes", "shoes3", "255");

        mProductList.add(p1);
        mProductList.add(p2);
        mProductList.add(p3);
    }

    public List<Product>getProductList() { return mProductList; }
}
