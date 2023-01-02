package com.myntra.backend.Entities;


import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@SequenceGenerator(name="order_id_seq", initialValue=501, allocationSize=100)

@Table(name = "Orders_10708700")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_id_seq")
    private int orderID;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipperID")
    private Shipper shipper;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JoinColumn(name = "orderID" )
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(int orderID, int customerID, Date orderDate, int shipperID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
    }
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


    public Shipper getShipper() {
        return shipper;
    }
    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }


    public Customer getCustomer() { return customer; }


    public void setCustomer(Customer customer) { this.customer = customer; }

    public int getOrderID() {

        return orderID;
    }

    public void setOrderID(int orderID) {

        this.orderID = orderID;
    }



    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
            //    ", customer=" + customer +

                ", date=" + orderDate;
    }
}