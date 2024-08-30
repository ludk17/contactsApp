package com.upn.contactsapp.entities;

import com.upn.contactsapp.IService;

public class Contact {
    public int id;
    public String name;
    public String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
