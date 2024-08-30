package com.upn.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upn.contactsapp.activities.CreateContactActivity;
import com.upn.contactsapp.adapters.ContactAdaptar;
import com.upn.contactsapp.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> elementos = new ArrayList<>();
    ContactAdaptar adaptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecyclerView();

        FloatingActionButton btnCreateContact = findViewById(R.id.btnCreateContact);
        btnCreateContact.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CreateContactActivity.class);
            startActivityForResult(intent, 100);

        });

    }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);

         if (requestCode == 100 && resultCode == 100) {
             String name = data.getStringExtra("CONTACT_NAME");
             String phone = data.getStringExtra("CONTACT_PHONE");
             Contact contact = new Contact(name, phone);

             elementos.add(contact);
             adaptar.notifyDataSetChanged();
         }

     }

    private void setUpRecyclerView() {
        RecyclerView rvContacts = findViewById(R.id.rvContacts);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        elementos.add(new Contact("Luis Mendoza", "9999999"));
        elementos.add(new Contact("Lionel Messi", "8888888"));
        elementos.add(new Contact("Cristiano Ronaldo", "777777"));
        elementos.add(new Contact("Neymar Jr", "666666"));
        elementos.add(new Contact("Cristhian Cueva", "55555"));

        adaptar = new ContactAdaptar(elementos);
        rvContacts.setAdapter(adaptar);
    }
}