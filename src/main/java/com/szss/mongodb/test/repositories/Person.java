package com.szss.mongodb.test.repositories;

import org.springframework.data.annotation.Id;

/**
 * Created by zcg on 15/9/17.
 */
public class Person {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private Address address;

    public Person(String firstname, String lastname, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
