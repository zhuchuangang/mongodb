package com.szss.mongodb.test.repositories;

import org.springframework.data.annotation.Id;

/**
 * Created by zcg on 15/9/17.
 */
public class Address {
    @Id
    private String id;
    private String city;
    private String province;
    private String address;

    public Address(String city, String province, String address) {
        this.city = city;
        this.province = province;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
