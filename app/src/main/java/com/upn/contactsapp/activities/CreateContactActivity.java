package com.upn.contactsapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;
import com.upn.contactsapp.services.ContactService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);


        Button btnGuardarContacto = findViewById(R.id.btnGuardarContacto);
        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://66d5b903f5859a7042673752.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService service = retrofit.create(ContactService.class);

        btnGuardarContacto.setOnClickListener(view -> {

            String name = etName.getText().toString();
            String phone = etPhone.getText().toString();

            Contact contact = new Contact(name, phone);

            service.create(contact).enqueue(new Callback<Contact>() {
                @Override
                public void onResponse(Call<Contact> call, Response<Contact> response) {
                    Log.i("MAIN_APP", String.valueOf(response.code()));

                    if (response.isSuccessful()) {

                        Contact newContact = response.body();

                        Intent intent = getIntent();
                        intent.putExtra("CONTACT", new Gson().toJson(newContact));

                        setResult(100, intent);
                        finish();

                    }

                }

                @Override
                public void onFailure(Call<Contact> call, Throwable throwable) {
                    Log.e("MAIN_APP", throwable.getMessage());
                }
            });







        });

    }
}