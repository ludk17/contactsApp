package com.upn.contactsapp.services;


import com.upn.contactsapp.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface UserService {
    @GET("/users")
    Call<List<User>> authenticate(@Query("email") String username, @Query("password") String password);

}
