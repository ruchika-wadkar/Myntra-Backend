package com.myntra.backend.Entities;

import javax.persistence.*;



@Entity
@Table(name = "customers_10708700")
@SequenceGenerator(name="customer_id_seq", initialValue=201, allocationSize=100)
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_id_seq")
    int customerID;
    private String customerName;
    private String address;
    private String city;
    private int postalCode;
    private String country;

    public Customer() {
    }

    public Customer(int customerID, int postalCode, String customerName, String address, String city, String country) {
        this.customerID = customerID;
        this.postalCode = postalCode;
        this.customerName = customerName;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                '}';
    }
}