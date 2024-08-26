package com.upn.contactsapp.interceptors;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.upn.contactsapp.LoginActivity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetrofitInterceptor implements Interceptor  {

    private final Activity activity;
    private final SharedPreferences mSharedPref;

    public RetrofitInterceptor(Activity activity) {
        this.activity = activity;
        mSharedPref = this.activity.getSharedPreferences("com.upn.contactsapp.123abc", Context.MODE_PRIVATE);

        // com.upn.contactsapp.123abc => representa un nombre unico donde se alamacenara la informacion

    }

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {

        Log.i("MAIN_APP", "Interceptor");

        String mToken = mSharedPref.getString("AUTH_SECURITY_TOKEN", "");

        Request.Builder requestBuilder = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json");

        if (!mToken.isEmpty()) {
            requestBuilder = requestBuilder.addHeader("Authorization", "Bearer " + mToken);
        }

        Response response = chain.proceed(requestBuilder.build());

        if (response.code() ==  401) {
            Log.i("MAIN_APP", "[Interceptor] Token expirado");
            doLogout();
        }

        if (response.code() ==  500) {
            Log.i("MAIN_APP", "[Interceptor] Error en el servidor");
        }


        return response;
    }

    private void doLogout() {
        Log.i("MAIN_APP", "Cerrar sesión");

        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.remove("AUTH_SECURITY_TOKEN");
        editor.apply();

        redirectToLoginActivity();
    }

    private void redirectToLoginActivity() {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
