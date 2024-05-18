package com.upn.contactsapp.main;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.upn.contactsapp.daos.ContactDAO;
import com.upn.contactsapp.entities.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDAO contactDAO();

    public static AppDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AppDatabase.class, "upnContactDB")
                .allowMainThreadQueries()
                .build();
    }
}
