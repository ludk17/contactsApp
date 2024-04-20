package com.upn.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upn.contactsapp.adapters.ContactItemAdapter;
import com.upn.contactsapp.entities.Contact;
import com.upn.contactsapp.services.IContactService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<Contact> mData = new ArrayList<>();
    private RecyclerView mRvContacts;
    private FloatingActionButton mbtnCreateContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://661d24b4e7b95ad7fa6c43d1.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Instanciar IContactService
        IContactService service = retrofit.create(IContactService.class);

        service.getAll("Lionel").enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {

                if (response.code() == 200) {
                    mData = response.body();

                    mRvContacts = findViewById(R.id.rvContacts);
                    mbtnCreateContact = findViewById(R.id.btnCreateContact);

                    setUpRecyclerView();
                    setUpBtnCreateContact();
                }
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "No se pudo conectar sa servidor", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setUpRecyclerView() {

        mRvContacts.setLayoutManager(new LinearLayoutManager(this));
        // configurar RV y agregar elementos en la lista
        ContactItemAdapter adapter = new ContactItemAdapter(mData);
        mRvContacts.setAdapter(adapter); //Me permite indicar que elementos debe mostrar el RV
    }

    private void setUpBtnCreateContact() {
        mbtnCreateContact.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ContactFormActivity.class);
            startActivity(intent);
        });
    }
}