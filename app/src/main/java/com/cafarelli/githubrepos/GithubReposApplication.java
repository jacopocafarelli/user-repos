package com.cafarelli.githubrepos;

import android.app.Application;

import com.cafarelli.githubrepos.di.AppModule;
import com.cafarelli.githubrepos.di.DaggerNetworkComponent;
import com.cafarelli.githubrepos.di.NetworkComponent;
import com.cafarelli.githubrepos.di.NetworkModule;


public class GithubReposApplication extends Application {

    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        networkComponent = DaggerNetworkComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("https://api.github.com"))
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }
}