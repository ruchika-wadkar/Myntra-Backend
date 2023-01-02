package com.myntra.backend.vo;

import javax.validation.constraints.*;

public class SupplierVo {

    private int supplierID;
    @NotBlank(message = "supplirname shoudld not be empty")
    private String supplierName;
    @NotBlank(message = "address should not be empty")
    private String Address;
    @NotBlank(message = "City should not be empty") private String city;
    @NotNull(message = "Postal code is mandatory")
    @Digits(integer = 6, fraction = 0)
    private int postalCode;
    @NotNull(message = "phone number is mandatory")
    @Min(10000000)
    private int phone;

    public SupplierVo() {
    }

    public SupplierVo(int supplierID, String supplierName, String address, String city, int postalCode, int phone) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        Address = address;
        this.city = city;
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
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone=" + phone +
                '}';
    }
}
