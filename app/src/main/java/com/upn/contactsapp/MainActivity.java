package com.upn.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.upn.contactsapp.adapters.ContactItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mData = new ArrayList<>();
    private RecyclerView mRvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set DE Datos
        mData.add("Dato 1");
        mData.add("Dato 2");
        mData.add("Dato 3");
        mData.add("Dato 4");
        mData.add("Dato 5");
        mData.add("Dato 6");
        mData.add("Dato 7");
        mData.add("Dato 8");
        mData.add("Dato 9");
        mData.add("Dato 10");



        mRvContacts = findViewById(R.id.rvContacts);
        mRvContacts.setLayoutManager(new LinearLayoutManager(this));


        // configurar RV y añadir elementos en la lista
        ContactItemAdapter adapter = new ContactItemAdapter(mData);
        mRvContacts.setAdapter(adapter); //Me permite indicar que elemntos debe mostrar el RV

    }
}