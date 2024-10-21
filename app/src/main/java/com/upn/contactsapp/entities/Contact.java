package com.upn.contactsapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {

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

    // Constructor de la clase Contact
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Método para asignar un ID
    public void setId(int id) {
        this.id = id;
    }

    // Método para obtener el ID
    public int getId() {
        return id;
    }
}
