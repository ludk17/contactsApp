package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;

public class FireBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);

        Button btn = findViewById(R.id.createfirebase);

        btn.setOnClickListener(v -> {

            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contact-list");

            Contact c1 = new Contact("Luis", "12345678");
            c1.id= 1;
            Contact c2 = new Contact("Miguel", "121233456");
            c2.id= 2;
            Contact c3 = new Contact("Daniel", "121233456");
            c3.id= 3;

            myRef.child(String.valueOf(c1.id)).setValue(c1);
            myRef.child(String.valueOf(c2.id)).setValue(c2);
            myRef.child(String.valueOf(c3.id)).setValue(c3);



        });


    }
}