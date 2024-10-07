package com.upn.contactsapp.interceptors;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JiraAPIClient {

    public static Retrofit getInstance(Context context) {
        return new Retrofit.Builder()
                .client(JiraAPIClient.getClient(context))
                .baseUrl("https://jiraupn.atlassian.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient getClient(Context context) {

        SharedPreferences sharedPref = context.getSharedPreferences("com.upn.contactsapp", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", null);

        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Basic " + token)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Accept", "application/json")
                        .build();
                return chain.proceed(newRequest);
            }


        }).build();
    }
}
