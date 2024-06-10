package com.upn.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.upn.contactsapp.entities.Login;
import com.upn.contactsapp.entities.TokenAuth;
import com.upn.contactsapp.services.AuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSharedPref = this.getSharedPreferences("com.upn.contactsapp.123abc", Context.MODE_PRIVATE);
        Button btnLogin = findViewById(R.id.btnLogin);
        mEmail = findViewById(R.id.txtEmail);
        mPassword = findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MAIN_APP", "click on login btn");
                doLogin();
            }
        });




        //        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("TOKEN", "abc abc abc");
//        editor.apply();


       // Log.i("MAIN_APP",  sharedPref.getString("TOKEN", "--"));


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    private void doLogin() {

        Log.i("MAIN_APP", "Iniciar Login");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demo.vetagile.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuthService auth = retrofit.create(AuthService.class);

        Login login = new Login();
        login.email = mEmail.getText().toString();
        login.password = mPassword.getText().toString();
        login.site = 1;

        Log.i("MAIN_APP", "data: " + new Gson().toJson(login));
        auth.login(login).enqueue(new Callback<TokenAuth>() {
            @Override
            public void onResponse(Call<TokenAuth> call, Response<TokenAuth> response) {


                if (response.isSuccessful()) {
                    // guardar el token para futuras llamadas
                    Log.i("MAIN_APP", new Gson().toJson(response.body()));
                    saveToken(response.body());

                } else if(response.code() == 401) {
                     // error ne contraseña
                } else if (response.code() == 422) {
                     // erro de validacions
                } else {

                }
            }

            @Override
            public void onFailure(Call<TokenAuth> call, Throwable throwable) {
                Log.e("MAIN_APP", throwable.getMessage());
            }
        });
    }

    private void redirectToClientActivity() {
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }

    private void saveToken(TokenAuth body) {

        // guardar en base de datos local
        // guardo en sharedPreferences
        //

        Log.i("MAIN_APP", "Guardando token en shared preferences");
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString("AUTH_SECURITY_TOKEN", body.token);
        editor.apply();

        redirectToClientActivity();
    }
}