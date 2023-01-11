package com.myntra.backend.Entities;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "suppliers_10708700")
@SequenceGenerator(name="suppliers_id_seq", initialValue=401, allocationSize=100)
public class Supplier {
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="suppliers_id_seq")
    @Id
    private int supplierID;
    private String supplierName;

    private String Address;
    private String City;
    private int postalCode;


    @Pattern(regexp = "(\\+91|0)[0-9]{10}")
    private int phone;

    public Supplier() {
    }

    public Supplier(int supplierID, String supplierName, String address, String city, int postalCode, int phone) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.Address = address;
        this.City = city;
        this.postalCode = postalCode;
        this.phone = phone;

    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }


    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", supplierName='" + supplierName + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", postalCode=" + postalCode +
                ", phone=" + phone +
                '}';
    }
}