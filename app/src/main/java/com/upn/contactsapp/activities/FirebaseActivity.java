package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_firebase);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Contactos");
            Contact contacto = new Contact("Lucho", "976");
            contacto.id = 1;
            Contact contacto2 = new Contact("Lucho2", "9762");
            contacto2.id = 2;
            Contact contacto3 = new Contact("Lucho3", "9763");
            contacto3.id = 3;
            List<Contact> contactoslista = new ArrayList<>();
            contactoslista.add(contacto3);
            myRef.setValue(contactoslista);
            myRef.child(String.valueOf(contacto.id)).setValue(contacto);
            myRef.child(String.valueOf(contacto2.id)).setValue(contacto2);
        });
        };
    }
