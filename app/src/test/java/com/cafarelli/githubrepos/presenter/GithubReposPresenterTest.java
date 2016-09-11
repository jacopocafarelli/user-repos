package com.cafarelli.githubrepos.presenter;

import com.cafarelli.githubrepos.usecase.ConnectivityUseCase;
import com.cafarelli.githubrepos.usecase.GetUserReposUseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GithubReposPresenterTest {

    @Mock
    private ConnectivityUseCase connectivityUseCase;
    @Mock
    private GetUserReposUseCase getUserReposUseCase;
    @Mock
    private GithubReposPresenter.View view;

    private GithubReposPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new GithubReposPresenter(connectivityUseCase, getUserReposUseCase);
        presenter.setView(view);
    }

    @Test
    public void onSearchReposWhenNoConnection() throws Exception {
        when(connectivityUseCase.isNetworkAvailable()).thenReturn(false);
        presenter.onSearchRepos("test");
        verify(view).showNoInternetConnection();
    }

    @Test
    public void onSearchReposWithEmptyQuery() throws Exception {
        when(connectivityUseCase.isNetworkAvailable()).thenReturn(true);
        presenter.onSearchRepos("");
        verify(view).showNoSearchWithEmpty();
    }
}
