package com.upn.contactsapp.services;

import com.upn.contactsapp.entities.Contact;
import com.upn.contactsapp.entities.PokemonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IPokemonService {

    @GET("/api/v2/pokemon")
    Call<PokemonResponse> getAll();
    @GET("/api/v2/pokemon")
    Call<PokemonResponse> getAll(@Query("offset") int offset, @Query("limit") int limit);

}
