package com.cafarelli.githubrepos.network;

import com.cafarelli.githubrepos.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("/users/{username}/repos")
    Call<List<Repo>> userRepos(@Path("username") String username);
}
