package com.cafarelli.githubrepos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplication()).getNetworkComponent().inject(this);

        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View view) {

    }
}
