package com.upn.contactsapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.upn.contactsapp.MainActivity;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.IssueResponse;
import com.upn.contactsapp.interceptors.JiraAPIClient;
import com.upn.contactsapp.services.IssueService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IssueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);

        SharedPreferences sharedPref = getSharedPreferences("com.upn.contactsapp", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", null);
        Log.i("LoginActivity", "TOKEN: " + token);

        if (token == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        Retrofit retrofit = JiraAPIClient.getInstance(this);
        IssueService service = retrofit.create(IssueService.class);

        service.getProjectIssues2("project = PIN").enqueue(new Callback<IssueResponse>() {
            @Override
            public void onResponse(Call<IssueResponse> call, Response<IssueResponse> response) {

                Log.i("MAIN_APP", String.valueOf(response.code()));
                Log.i("MAIN_APP", new Gson().toJson(response.body()));
                Log.i("MAIN_APP", new Gson().toJson(response.body()));
                Log.i("MAIN_APP", new Gson().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<IssueResponse> call, Throwable throwable) {
                Log.e("MAIN_APP", throwable.getMessage());
            }
        });

    }
}