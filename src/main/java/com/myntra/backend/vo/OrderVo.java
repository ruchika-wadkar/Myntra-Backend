package com.myntra.backend.vo;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class OrderVo {


    private int orderID;
    @NotNull(message = "Date Required")
    @Pattern(regexp ="^(2[0-9]{3})-(0[1-9]|1[012])-(0[1-9]|[12][1-9]|[3][01])", message = "date should be in the yyyy-mm-dd required format")
    private String orderDate;


    @NotNull(message = "Customer ID required")
    private int CustomerID;
    @NotNull(message = "Shipper ID required")
    private int shipperID;
    @NotNull(message = "Order Detail required")
    private List<OrderDetailVo> orderDetails;

    public OrderVo() {
    }

    public OrderVo(int orderID, int customerID, String orderDate, int shipperID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.CustomerID = customerID;
        this.shipperID = shipperID;

    }



    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {this.orderID = orderID;}
    public int getCustomerID() {
        return CustomerID;
    }
    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }
    public int getShipperID() {
        return shipperID;
    }
    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetailVo> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<OrderDetailVo> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "date='" + orderDate + '\'' +
                ", CustomerID=" + CustomerID +
                ", shipperID=" + shipperID +
                ", orderDetails=" + orderDetails +
                '}';
    }











}