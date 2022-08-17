package com.example.welcomeservice.entity;

import javax.persistence.*;



@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    @Column(nullable = false)
    private String streetLine;
    private String additionalStreet;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private int postCode;

    public Address() {

    }

    public Address(int addressId, String streetLine, String additionalStreet, String city, String state, int postCode) {
        this.addressId = addressId;
        this.streetLine = streetLine;
        this.additionalStreet = additionalStreet;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreetLine() {
        return streetLine;
    }

    public void setStreetLine(String streetLine) {
        this.streetLine = streetLine;
    }

    public String getAdditionalStreet() {
        return additionalStreet;
    }

    public void setAdditionalStreet(String additionalStreet) {
        this.additionalStreet = additionalStreet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

}
