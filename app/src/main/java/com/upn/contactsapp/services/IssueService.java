package com.upn.contactsapp.services;

import com.upn.contactsapp.entities.IssueComment;
import com.upn.contactsapp.entities.IssueResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IssueService {

    @POST("/rest/api/2/issue/{issueKey}/comment")
    @Headers({
        "Authorization: Basic YXJ0dXJvLnVwbmNhakBnbWFpbC5jb206QVRBVFQzeEZmR0YwdDBoVmYtM2xreE92TmJ1bTlqekFraUx3U2x5b0pwS0V0X3dIZzB2SU45emppX2NEWkRQbVZLZGs0NFpoSDhkMHVIVmZnUkdOUUlUcTE5ei1nRFlvMDdHZTBzVVpla2FSQW9yX3UwNE9uQ2psS3laMDdZSF8wX3hJLVQ2M29tYklVZzB4T0hrNG9CTkt4Z3F0bE1pWFFtaU0tQWlQMEFIRGV1enprV1QybE80PTE4QzQzOTVD"
    })
    Call<Void> comentar(@Path("issueKey") String issueKey, @Body IssueComment comment);

    @GET("/rest/api/2/search")
    Call<IssueResponse> getProjectIssues(@Query("jql") String jql);


    @GET("/rest/api/2/search")
    Call<IssueResponse> getProjectIssues2(@Query("jql") String jql);


    @GET("/rest/api/2/search")
    Call<IssueResponse> getProjectIssues3(@Query("jql") String jql);


    @GET("/rest/api/2/search")
    Call<IssueResponse> getProjectIssues4(@Query("jql") String jql);
}
