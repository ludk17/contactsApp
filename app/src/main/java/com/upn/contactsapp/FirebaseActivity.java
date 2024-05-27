package com.upn.contactsapp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.upn.contactsapp.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class FirebaseActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private List<Contact> mContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        Log.i("MAIN_APP <FirebaseActivity>", "Iniciando actividad");

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mDatabase = FirebaseDatabase.getInstance().getReference("contacts");

//        addContact();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                //Log.i("MAIN_APP <FirebaseActivity>", snapshot.getValue(String.class));
                //snapshot.getChildren()
                for(DataSnapshot data: snapshot.getChildren()){
                    Contact contact = data.getValue(Contact.class);
                    mContacts.add(contact);

                    Log.i("MAIN_APP <FirebaseActivity>", new Gson().toJson(contact));
                }

                // llar adpater


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void addContact() {
        Contact contact = new Contact();
        contact.id = 2;
        contact.name = "Lionel";
        contact.lastName = "Messi";
        contact.phoneNumber = "99999999";
//
//        mDatabase.push().setValue(contact);
        mDatabase.setValue(contact);

    }
}