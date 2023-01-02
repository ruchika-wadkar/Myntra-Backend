package com.myntra.backend.Entities;

import javax.persistence.*;

@Table(name = "shippers_10708700")
@Entity
@SequenceGenerator(name="shippers_id_seq", initialValue=301, allocationSize=100)
public class Shipper {



    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shippers_id_seq")
    private int shipperID;
    private String shipperName;
    private String phone;


    public Shipper() {
    }

    public Shipper(int shipperID, String shipperName, String phone) {
        this.shipperID = shipperID;

        this.shipperName = shipperName;
        this.phone = phone;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "shipperID=" + shipperID +
                ", shipperName='" + shipperName +
                ", phone=" + phone + '\'' +
                '}';
    }
}