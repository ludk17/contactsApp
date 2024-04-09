package com.upn.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upn.contactsapp.adapters.ContactItemAdapter;
import com.upn.contactsapp.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Contact> mData = new ArrayList<>();
    private RecyclerView mRvContacts;
    private FloatingActionButton mbtnCreateContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set DE Datos
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Lionel", "Messi", "9999999", "https://cdn-icons-png.flaticon.com/512/805/805404.png"));
        mData.add(new Contact("Cristiano", "Ronaldo", "9999999", "https://cdn.icon-icons.com/icons2/1371/PNG/512/cristianoronaldo_90805.png"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));

        mRvContacts = findViewById(R.id.rvContacts);
        mbtnCreateContact = findViewById(R.id.btnCreateContact);

        setUpRecyclerView();
        setUpBtnCreateContact();
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