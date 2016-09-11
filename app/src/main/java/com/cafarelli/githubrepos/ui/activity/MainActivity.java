package com.cafarelli.githubrepos.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cafarelli.githubrepos.GithubReposApplication;
import com.cafarelli.githubrepos.R;
import com.cafarelli.githubrepos.model.Repo;
import com.cafarelli.githubrepos.presenter.GithubReposPresenter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GithubReposPresenter.View {

    @Inject
    GithubReposPresenter presenter;

    private Button searchButton;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextInputEditText searchInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((GithubReposApplication) getApplication()).getNetworkComponent().inject(this);

        setContentView(R.layout.activity_main);
        searchInputEditText = (TextInputEditText) findViewById(R.id.text_input_search);
        searchButton = (Button) findViewById(R.id.btn_search);
        searchButton.setOnClickListener(this);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srf_main_container);
        swipeRefreshLayout.setEnabled(false);

        presenter.setView(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_search) {
            presenter.onSearchRepos(searchInputEditText.getText().toString());
        }
    }

    @Override
    public void showNoInternetConnection() {
        Snackbar.make(searchButton, getString(R.string.error_no_connection), Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void stopLoading() {
        swipeRefreshLayout.setEnabled(false);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showRepos(List<Repo> repos) {

    }

    @Override
    public void showEmpty() {
        Snackbar.make(searchButton, getString(R.string.error_empty_repos), Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void showError() {
        Snackbar.make(searchButton, getString(R.string.error_downloading_repos), Snackbar.LENGTH_INDEFINITE).show();
    }
}
