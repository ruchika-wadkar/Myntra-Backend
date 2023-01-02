package com.myntra.backend.vo;

import javax.persistence.Id;
import javax.validation.constraints.*;

public class ShipperVo {



    @Id
    private int shipperID;

    @NotBlank(message = "Shippername should not be empty")
    private String ShipperName;
    @NotNull(message = "phone number is mandatory")
    @Pattern(regexp = "(\\+91|0)[0-9]{10}")
    private String phone;


    public ShipperVo(){

    }
    public ShipperVo(int shipperID, String shipperName, String phone) {
        this.shipperID = shipperID;
        this.ShipperName = shipperName;
        this.phone = phone;
    }




    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getShipperName() {
        return ShipperName;
    }

    public void setShipperName(String shipperName) {
        ShipperName = shipperName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "shipperID=" + shipperID +
                ", ShipperName='" + ShipperName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
