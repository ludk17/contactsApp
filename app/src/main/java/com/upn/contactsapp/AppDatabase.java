package com.upn.contactsapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.upn.contactsapp.daos.ContactDAO;
import com.upn.contactsapp.entities.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase dbInstance;

    public abstract ContactDAO contactDAO();

    public static AppDatabase getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = Room.databaseBuilder(context, AppDatabase.class, "database-contacts")
                    .allowMainThreadQueries()
                    .build();



        }
        return dbInstance;
    }
}