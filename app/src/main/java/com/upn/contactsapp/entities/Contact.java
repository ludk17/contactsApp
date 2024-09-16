package com.upn.contactsapp.entities;

import com.upn.contactsapp.IService;

public class Contact {
    public int id;
    public String name;
    public String phone;
    public String image;
    public String imagePath;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
