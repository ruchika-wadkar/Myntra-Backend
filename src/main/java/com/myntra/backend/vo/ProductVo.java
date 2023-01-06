package com.myntra.backend.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductVo {

    private int productID;
    private int supplierID;

    @Min(value = 1,message = "Minimum 1 Unit required")
    private int unit;
    @Min(value = 10,message = "Minimum 10 price required")
    private int price;


    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    @NotBlank(message = "Please enter product image url")
    private String productImg;


    @NotBlank(message = "Please enter product name")
    private String productName;

    public ProductVo() {
    }

    public ProductVo(int productID,
                     int supplierID,
                     int unit, int price, String productName) {
        this.productID = productID;
        this.supplierID = supplierID;
        this.unit = unit;
        this.price = price;
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", supplierID=" + supplierID +
                ", unit=" + unit +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }

}













