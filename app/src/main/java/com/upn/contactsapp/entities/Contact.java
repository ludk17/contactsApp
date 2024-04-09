package com.upn.contactsapp.entities;

import androidx.annotation.NonNull;

public class Contact {
    public String name;
    public String lastName;
    public String phoneNumber;

    public String imageUrl = "https://google.com";

    public Contact(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


}
