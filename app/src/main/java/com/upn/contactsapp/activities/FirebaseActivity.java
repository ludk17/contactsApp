package com.upn.contactsapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.MainActivity;
import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;
import com.upn.contactsapp.entities.Service;
import com.upn.contactsapp.entities.User;
import com.upn.contactsapp.services.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        Button btn = findViewById(R.id.btnFirebase);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("contact");

                Contact contact = new Contact("Juan","925364123");

                myRef.child("1").setValue(contact);


              //  myRef.setValue("Hello, World!");
            }
        });
    }
}