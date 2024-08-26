package com.upn.contactsapp.services;

import com.upn.contactsapp.entities.Client;
import com.upn.contactsapp.entities.Pager;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;

public interface ClientService {

//    @Headers("Accept: application/json")
    @GET("/api/v1/clients")
    Call<Pager<Client>> getAll();


}
