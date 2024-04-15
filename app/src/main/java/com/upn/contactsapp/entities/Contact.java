package com.upn.contactsapp.entities;

import androidx.annotation.NonNull;

public class Contact {

    public int id;

    public String name;
    public String lastName;
    public String phoneNumber;
    public String imageUrl;

    public Contact(String name, String lastName, String phoneNumber, String imageUrl) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
    }

    public Contact(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
    }


}
