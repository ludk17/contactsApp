package com.upn.contactsapp;

import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;
import com.upn.contactsapp.entities.Contact;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        Button btn = findViewById(R.id.btn_create_firebase);

        btn.setOnClickListener(v ->{
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contacts");

            Contact c1 = new Contact("Luis","123456");
            c1.id = 1;
            Contact c2 = new Contact("Miguel","123456");
            c2.id = 2;


            myRef.child(String.valueOf(c1.id)).setValue(c1);
            myRef.child(String.valueOf(c2.id)).setValue(c2);


        });


    }
}