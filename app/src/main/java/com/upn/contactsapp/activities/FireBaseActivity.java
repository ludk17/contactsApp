package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;

import java.util.List;

public class FireBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);

        Button btnFirebase = findViewById(R.id.btnFirebase);

        btnFirebase.setOnClickListener(view -> {
            // Obtener instancia de Firebase y escribir un mensaje en la base de datos
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contacts");

            Contact c1 = new Contact("Pollo" , "97973");
            c1.id=1;
            Contact c2 = new Contact("Jherson" , "718217");
            c2.id=2;
            //myRef.setValue(c);

            myRef.child(String.valueOf(c1.id)).setValue(c1);
            myRef.child(String.valueOf(c2.id)).setValue(c2);

        });
    }
}