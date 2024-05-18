package com.upn.contactsapp.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.upn.contactsapp.entities.Contact;

import java.util.List;

@Dao
public interface ContactDAO {

    @Query("SELECT * FROM contacts")
    List<Contact> getAll();

    @Insert
    void create(Contact... contact);

    @Query("DELETE FROM contacts")
    void deleteAll();
}
