package com.myntra.backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "products_10708700")
@SequenceGenerator(name="products", initialValue=101, allocationSize=100)
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="products_id_seq")
    private int productID;

    @ManyToOne
    @JoinColumn(name = "supplierID")
    private Supplier supplier;

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    private String productImg;
    private int unit;
    private int price;
    private String productName;

    public Product() {
    }

    public Product(int productID,
                   int supplierID,
                   int unit, int price, String productName) {
        this.productID = productID;
//        this.supplierID = supplierID;
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

//    public int getSupplierID() {
//        return supplierID;
//    }
//
//    public void setSupplierID(int supplierID) {
//        this.supplierID = supplierID;
//    }

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

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
             //   ", supplierID=" + supplierID +
                ", unit=" + unit +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}













