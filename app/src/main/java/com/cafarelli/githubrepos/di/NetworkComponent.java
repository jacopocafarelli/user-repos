package com.cafarelli.githubrepos.di;

import com.cafarelli.githubrepos.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {AppModule.class, NetworkModule.class})
public interface NetworkComponent {
    void inject(MainActivity activity);
}
