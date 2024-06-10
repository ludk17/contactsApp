package com.upn.contactsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.upn.contactsapp.entities.Client;
import com.upn.contactsapp.entities.Pager;
import com.upn.contactsapp.services.ClientService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientActivity extends AppCompatActivity {

    private SharedPreferences mSharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        mSharedPref = this.getSharedPreferences("com.upn.contactsapp.123abc", Context.MODE_PRIVATE);

        String token = mSharedPref.getString("AUTH_SECURITY_TOKEN", "");

        Log.i("MAIN_APP", "El token es: " + token);


        doGetClients();

    }

    private void doGetClients() {

        Log.i("MAIN_APP", "Obtener clientes");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demo.vetagile.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClientService service = retrofit.create(ClientService.class);

        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer " + mSharedPref.getString("AUTH_SECURITY_TOKEN", ""));
        service.getAll(headers).enqueue(new Callback<Pager<Client>>() {
            @Override
            public void onResponse(Call<Pager<Client>> call, Response<Pager<Client>> response) {
                Log.i("MAIN_APP",  String.valueOf(response.code()));
                Log.i("MAIN_APP", new Gson().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<Pager<Client>> call, Throwable throwable) {
                Log.e("MAIN_APP", throwable.getMessage());
            }
        });
    }
}