package com.upn.contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.upn.contactsapp.entities.Contact;

public class ContactDetailActivity extends AppCompatActivity {

    private Contact mContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Intent intent = getIntent();
        String sData = intent.getStringExtra("contact");

        Log.i("MAIN_APP", sData);

        mContact = new Gson().fromJson(sData, Contact.class);

        setUpView();
    }

    private void setUpView() {
        TextView tvContactName = findViewById(R.id.tvContactName);
        TextView tvContactLastName = findViewById(R.id.tvContactLastName);
        TextView tvContactPhoneNumber = findViewById(R.id.tvContactPhoneNumber);

        tvContactName.setText(mContact.name);
        tvContactLastName.setText(mContact.lastName);
        tvContactPhoneNumber.setText(mContact.phoneNumber);
    }
}