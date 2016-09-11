package com.cafarelli.githubrepos.usecase;

import com.cafarelli.githubrepos.model.Repo;
import com.cafarelli.githubrepos.network.GithubService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class GetUserReposUseCase {

    @Inject
    GithubService githubService;

    @Inject
    public GetUserReposUseCase() {

    }

    public Call<List<Repo>> getUserRepos(String username) {
        return githubService.userRepos(username);
    }
}
