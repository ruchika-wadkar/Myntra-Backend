package com.myntra.backend.Entities;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "OrderDetails_10708700")
@SequenceGenerator(name="OrderDetails_id_seq", initialValue=601, allocationSize=100)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OrderDetails_id_seq")
    private int orderDetailId;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;
    @Min(value = 1, message = "Minimum 1 quantity required")
    private int quantity;





    public OrderDetail(){

    }
    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDetail(int orderDetailId, int orderID, int productID, int quantity ) {
        this.orderDetailId = orderDetailId;
        this.quantity = quantity;

    }




    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", quantity=" + quantity +
               // ", product=" + product +
                '}';
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
