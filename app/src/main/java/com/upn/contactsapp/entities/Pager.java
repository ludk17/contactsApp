package com.upn.contactsapp.entities;

import java.util.List;

public class Pager <T> {

    public int totalItems;
    public int itemsPerPage;
    public int currentPage;
    public List<T> items;
}
