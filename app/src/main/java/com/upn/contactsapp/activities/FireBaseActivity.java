package com.upn.contactsapp.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;

import java.util.UUID;

public class FireBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);

        Button btnRes=findViewById(R.id.btnRegister);

        btnRes.setOnClickListener(v -> {
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
//            DatabaseReference myRef = database.getReference("Contacts");
            DatabaseReference myRef = database.getReference("Contactsuuid");

//            Contact con=new Contact("Alex","123");
//            con.id=1;
//            Contact c2=new Contact("Franco","321");
//            c2.id=2;
//            myRef.setValue(con);

            Contact c1=new Contact("Alex2","123");
            c1.uuid= UUID.randomUUID().toString();
            Contact c2=new Contact("Franco2","321");
            c2.uuid=UUID.randomUUID().toString();
//            myRef.child(String.valueOf(con.id)).setValue(con);
//            myRef.child(String.valueOf(c2.id)).setValue(c2);

            myRef.child(c1.uuid).setValue(c1);
            myRef.child(c2.uuid).setValue(c2);
        });

    }
}