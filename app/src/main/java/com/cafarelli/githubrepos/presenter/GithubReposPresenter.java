package com.cafarelli.githubrepos.presenter;

import com.cafarelli.githubrepos.model.Repo;
import com.cafarelli.githubrepos.usecase.ConnectivityUseCase;
import com.cafarelli.githubrepos.usecase.GetUserReposUseCase;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubReposPresenter {

    private ConnectivityUseCase connectivityUseCase;
    private GetUserReposUseCase getUserReposUseCase;
    private GithubReposPresenter.View view;

    @Inject
    public GithubReposPresenter(ConnectivityUseCase connectivityUseCase, GetUserReposUseCase getUserReposUseCase) {
        this.connectivityUseCase = connectivityUseCase;
        this.getUserReposUseCase = getUserReposUseCase;
    }

    public void setView(GithubReposPresenter.View view) {
        this.view = view;
    }

    public void onSearchRepos(String username) {
        if (!connectivityUseCase.isNetworkAvailable()) {
            view.showNoInternetConnection();
            return;
        }

        if (username == null || username.isEmpty()) {
            view.showNoSearchWithEmpty();
            return;
        }

        view.showLoading();
        getUserReposUseCase.getUserRepos(username).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                view.stopLoading();
                List<Repo> repos = response.body();
                if (repos != null && !repos.isEmpty()) {
                    view.showRepos(repos);
                } else {
                    view.showEmpty();
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable throwable) {
                view.stopLoading();
                view.showError();
            }
        });
    }

    public interface View {
        void showNoInternetConnection();

        void showLoading();

        void stopLoading();

        void showRepos(List<Repo> repos);

        void showEmpty();

        void showError();

        void showNoSearchWithEmpty();
    }
}
