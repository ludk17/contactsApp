package com.upn.contactsapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.upn.contactsapp.R;

public class CreateContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);


        Button btnGuardarContacto = findViewById(R.id.btnGuardarContacto);
        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);


        btnGuardarContacto.setOnClickListener(view -> {

            String name = etName.getText().toString();
            String phone = etPhone.getText().toString();

            Intent intent = getIntent();
            intent.putExtra("CONTACT_NAME", name);
            intent.putExtra("CONTACT_PHONE", phone);

            setResult(100, intent);
            finish();

        });

    }
}