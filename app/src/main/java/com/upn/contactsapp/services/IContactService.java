package com.upn.contactsapp.services;

import com.upn.contactsapp.entities.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IContactService {

    @GET("/contacts")
    Call<List<Contact>> getContacts();

}
