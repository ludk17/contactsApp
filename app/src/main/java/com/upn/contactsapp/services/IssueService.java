package com.upn.contactsapp.services;

import com.upn.contactsapp.entities.IssueResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IssueService {

    @GET("/rest/api/2/search")
    Call<IssueResponse> getProjectIssues(@Query("jql") String jql);


    @GET("/rest/api/2/search")
    Call<IssueResponse> getProjectIssues2(@Query("jql") String jql);


    @GET("/rest/api/2/search")
    Call<IssueResponse> getProjectIssues3(@Query("jql") String jql);


    @GET("/rest/api/2/search")
    Call<IssueResponse> getProjectIssues4(@Query("jql") String jql);
}
