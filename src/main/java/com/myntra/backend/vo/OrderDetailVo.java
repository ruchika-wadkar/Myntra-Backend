package com.myntra.backend.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderDetailVo {

    private int orderDetailID;
    private int orderID;
    @NotNull(message = " Quantity required")
    @Min(value = 1, message = "minimum 1 unit required")
    private int quantity;
    @NotNull(message = "ProductID required")
    private int productID;

    public OrderDetailVo(int orderDetailID, int orderID, int productID, int quantity) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;

        this.productID = productID;
        this.quantity = quantity;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailID=" + orderDetailID +
                ", orderID=" + orderID +
                ", quantity=" + quantity +
                ", productID=" + productID +
                '}';
    }
}
