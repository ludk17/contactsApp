package com.upn.contactsapp.services;

import com.upn.contactsapp.entities.Login;
import com.upn.contactsapp.entities.TokenAuth;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthService {

    @POST("/api/v1/auth/login")
    Call<TokenAuth> login(@Body Login login);
}
