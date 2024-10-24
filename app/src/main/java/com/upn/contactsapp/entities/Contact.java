package com.upn.contactsapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.upn.contactsapp.IService;

@Entity(tableName = "contacts")
public class Contact {

    public String uuid;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "local_id")
    transient public int localId;

    public int id;

    @ColumnInfo(name = "name")
    public String name;

    public String phone;
    public String image;

    @ColumnInfo(name = "image_path")
    public String imagePath;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
