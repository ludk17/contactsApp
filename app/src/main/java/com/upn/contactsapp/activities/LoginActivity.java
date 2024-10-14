package com.upn.contactsapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.upn.contactsapp.MainActivity;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.User;
import com.upn.contactsapp.services.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPref = getSharedPreferences("com.upn.contactsapp", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", null);
        Log.i("LoginActivity", "TOKEN: " + token);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://66d5b903f5859a7042673752.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService service = retrofit.create(UserService.class);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> {

            String username = "email 1";
            String password = "password 1";

            service.authenticate(username, password).enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (response.code() == 404) {
                        Log.d("LoginActivity", "Usuario no encontrado");
                        return;
                    }
                    Log.d("LoginActivity", "Usuario encontrado autenticado");
                    // authenticarme

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("TOKEN", "YXJ0dXJvLnVwbmNhakBnbWFpbC5jb206QVRBVFQzeEZmR0YwdDBoVmYtM2xreE92TmJ1bTlqekFraUx3U2x5b0pwS0V0X3dIZzB2SU45emppX2NEWkRQbVZLZGs0NFpoSDhkMHVIVmZnUkdOUUlUcTE5ei1nRFlvMDdHZTBzVVpla2FSQW9yX3UwNE9uQ2psS3laMDdZSF8wX3hJLVQ2M29tYklVZzB4T0hrNG9CTkt4Z3F0bE1pWFFtaU0tQWlQMEFIRGV1enprV1QybE80PTE4QzQzOTVD");
                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.d("LoginActivity", "Error: " + t.getMessage());
                }
            });


        });

    }
}