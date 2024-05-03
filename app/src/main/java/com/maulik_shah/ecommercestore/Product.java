package com.maulik_shah.ecommercestore;

public class Product {
    private String name;
    private String description;
    private String product_image;
    private String price;

    public Product(){

    }

    public Product(String name, String description, String product_image, String price) {
        this.name = name;
        this.description = description;
        this.product_image = product_image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getDescription() {
        return description;
    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public String getProduct_image() {
        return product_image;
    }
//
//    public void setProduct_image(String product_image) {
//        this.product_image = product_image;
//    }

    public String getPrice() {
        return price;
    }

//    public void setPrice(String price) {
//        this.price = price;
//    }
}
