package com.myntra.backend.vo;

import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerVo {
    @Id
    int customerID;
    @NotBlank(message = "customer name should not be empty.")
    String customerName;

    @NotBlank (message = "Address cannot be empty!")
    String address;
    @NotBlank(message = " City cannot be empty!")
    String city;
    @NotNull(message = "Postal code is mandatory")
    @Digits(integer = 6, fraction = 0)
    int postalCode;

    @NotBlank(message = "country should not be empty")
    String country;

    public CustomerVo() {
    }

    public CustomerVo(int customerID, String customerName, String address, String city, int postalCode, String country) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
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