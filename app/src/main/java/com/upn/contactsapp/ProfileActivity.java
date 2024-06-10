package com.upn.contactsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.upn.contactsapp.entities.Profile;
import com.upn.contactsapp.services.IProfileService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    Retrofit retrofit;
    IProfileService service;
    EditText mEtNombre;
    Profile profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button btnSave = findViewById(R.id.btnSave);
        mEtNombre = findViewById(R.id.etNombre);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://661d24b4e7b95ad7fa6c43d1.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(IProfileService.class);

        setUpPofile();


        btnSave.setOnClickListener(v -> {
            saveOrUpdateProfile();
        });

    }

    private void setUpPofile() {

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization",sharedPref.getString("TOKEN", ""));

        service.find(headers, 1).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.isSuccessful()) {
                    profile = response.body();
                    mEtNombre.setText(profile.name);
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable throwable) {

            }
        });
    }

    private void saveOrUpdateProfile() {


        if (profile == null) {
            createProfile();
        } else {
            updateProfile();
        }



        finish();
    }

    private void updateProfile() {
        profile.name = mEtNombre.getText().toString();
        service.update(1, profile).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                Toast.makeText(ProfileActivity.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable throwable) {

            }
        });
    }

    private void createProfile() {
        profile = new Profile();
        profile.id = 1;
        profile.name = mEtNombre.getText().toString();
        service.create(profile).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                Toast.makeText(ProfileActivity.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable throwable) {

            }
        });
    }
}