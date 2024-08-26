package com.upn.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.upn.contactsapp.base.RetrofitUtil;
import com.upn.contactsapp.entities.Client;
import com.upn.contactsapp.entities.Pager;
import com.upn.contactsapp.services.ClientService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ClientActivity extends AppCompatActivity {

    private SharedPreferences mSharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        mSharedPref = this.getSharedPreferences("com.upn.contactsapp.123abc", Context.MODE_PRIVATE);

        doGetClients();


        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(view -> {
            Log.i("MAIN_APP", "click on logout btn");
            doLogout();
        });

    }

    private void doLogout() {
        Log.i("MAIN_APP", "Cerrar sesión");

        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.remove("AUTH_SECURITY_TOKEN");
        editor.apply();

        redirectToLoginActivity();
    }

    private void redirectToLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void doGetClients() {

        Log.i("MAIN_APP", "Obtener clientes");

        Retrofit retrofit = RetrofitUtil.getRetrofit(this);

        ClientService service = retrofit.create(ClientService.class);

        service.getAll().enqueue(new Callback<Pager<Client>>() {
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