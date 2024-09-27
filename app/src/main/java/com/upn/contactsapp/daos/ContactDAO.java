package com.upn.contactsapp.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.upn.contactsapp.entities.Contact;

import java.util.List;

@Dao
public interface ContactDAO {

    @Query("SELECT * FROM contacts WHERE id = :remoteId")
    Contact findRemote(int remoteId);

    @Query("SELECT * FROM contacts")
    List<Contact> getAll();

    @Query("UPDATE contacts SET id=:remoteId WHERE local_id = :localId")
    void update(int localId, int remoteId);

    @Insert
    long insert(Contact contact);
}
