package com.upn.contactsapp.base;

import android.app.Activity;
import android.content.Context;

import com.upn.contactsapp.interceptors.RetrofitInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private static final String BASE_URL = "https://demo.vetagile.com";
    public static Retrofit getRetrofit(Activity activity) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new RetrofitInterceptor(activity));

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public static Retrofit getRetrofit(String baseURL, Activity activity) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new RetrofitInterceptor(activity));

        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
