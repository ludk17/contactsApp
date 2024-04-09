package com.upn.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.upn.contactsapp.adapters.ContactItemAdapter;
import com.upn.contactsapp.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Contact> mData = new ArrayList<>();
    private RecyclerView mRvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set DE Datos
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Lionel", "Messi", "9999999"));
        mData.add(new Contact("Cristiano", "Ronaldo", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));
        mData.add(new Contact("Luis", "Mendoza", "9999999"));

        mRvContacts = findViewById(R.id.rvContacts);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        mRvContacts.setLayoutManager(new LinearLayoutManager(this));
        // configurar RV y agregar elementos en la lista
        ContactItemAdapter adapter = new ContactItemAdapter(mData);
        mRvContacts.setAdapter(adapter); //Me permite indicar que elementos debe mostrar el RV
    }
}