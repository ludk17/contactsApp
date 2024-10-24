package com.upn.contactsapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.entities.Contact;

import java.util.List;
import java.util.UUID;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        Button btn = findViewById(R.id.btnCreateOnFirebase);

        btn.setOnClickListener(v -> {
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contacts");


            Contact c1 = new Contact("Luis", "12345678");
            c1.uuid = UUID.randomUUID().toString();
            Contact c2 = new Contact("Miguel", "123456");
            c2.uuid = UUID.randomUUID().toString();

            myRef.child(c1.uuid).setValue(c1);
            myRef.child(c2.uuid).setValue(c2);

        });

    }
}