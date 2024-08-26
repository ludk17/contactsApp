package com.upn.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.upn.contactsapp.adapters.ContactAdaptar;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = findViewById(R.id.rvContacts);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        List<String> elementos = new ArrayList<>();
        elementos.add("Luis Mendoza");
        elementos.add("Lionel Messi");
        elementos.add("Cristiano Ronaldo");
        elementos.add("Neymar Jr");

        ContactAdaptar adaptar = new ContactAdaptar(elementos);
        rvContacts.setAdapter(adaptar);
    }
}