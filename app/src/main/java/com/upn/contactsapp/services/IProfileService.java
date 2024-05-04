package com.upn.contactsapp.services;

import com.upn.contactsapp.entities.Contact;
import com.upn.contactsapp.entities.Profile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IProfileService {

    @GET("/profiles/{id}")
    Call<Profile> find(@Path("id") int id);

    @POST("/profiles")
    Call<Profile> create(@Body Profile profile);

    @PUT("/profiles/{id}")
    Call <Profile> update(@Path("id") int id, @Body Profile profile);


}
