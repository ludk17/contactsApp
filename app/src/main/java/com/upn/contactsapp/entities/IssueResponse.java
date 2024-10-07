package com.upn.contactsapp.entities;

import java.util.List;

public class IssueResponse {
    int total;
    List<Issue> issues;

    public class Issue {
        int id;
        String key;
    }
}
