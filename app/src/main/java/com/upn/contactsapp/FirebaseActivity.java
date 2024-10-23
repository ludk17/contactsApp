package com.upn.contactsapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.FirebaseDatabaseKtxRegistrar;
import com.upn.contactsapp.entities.Contact;

import java.util.List;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        Button btn = findViewById(R.id.btnCreateOnFirebase);

        btn.setOnClickListener(v -> {
                // Write a message to the database
                // ejemplo de de metodo para subir a firedatabase

                //FirebaseDatabase database = FirebaseDatabase.getInstance();
                //DatabaseReference myRef = database.getReference("mensaje");

                //myRef.setValue("Hola Mundo");

                //metodo 1 para subir a firedatabase nombre y numero de contactos.

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("contacts");
                Contact c1 = new Contact("Diego", "1596327");
                c1.id= 1;
                Contact c2 = new Contact("Alonso", "159632");
                c2.id= 2;

                myRef.child(String.valueOf(c1.id)).setValue(c1);
                myRef.child(String.valueOf(c2.id)).setValue(c2);

                //metodo 2 para subir a firedatabase nombre y numero de contactos.

                //FirebaseDatabase database = FirebaseDatabase.getInstance();
                //DatabaseReference myRef = database.getReference("contacts-list");
                //Contact c1 = new Contact("Diego", "159632");
                //c1.id= 1;
                //Contact c2 = new Contact("Alonso", "159632");
                //c2.id= 2;

                //List<Contact> contactList=List.of(c1, c2);
                //myRef.setValue(contactList);
        });
    }
}