package com.upn.contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.upn.contactsapp.entities.Contact;
import com.upn.contactsapp.services.IContactService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ContactFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);


        Button btnGuardar = findViewById(R.id.btnGuardar);
        EditText edtName = findViewById(R.id.edtName);
        EditText edtLastName = findViewById(R.id.edtLastName);
        EditText edtPhoneNumber = findViewById(R.id.edtPhoneNumber);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://661d24b4e7b95ad7fa6c43d1.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Instanciar IContactService
        IContactService service = retrofit.create(IContactService.class);
        btnGuardar.setOnClickListener(view -> {

            Contact contact = new Contact();
            contact.name = edtName.getText().toString();
            contact.lastName = edtLastName.getText().toString();
            contact.phoneNumber = edtPhoneNumber.getText().toString();

            service.create(contact).enqueue(new Callback<Contact>() {
                @Override
                public void onResponse(Call<Contact> call, Response<Contact> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(ContactFormActivity.this, "Se creo contacto correctamente", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<Contact> call, Throwable throwable) {

                }
            });
        });

    }
}