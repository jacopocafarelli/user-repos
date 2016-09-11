package com.cafarelli.githubrepos.model;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("html_url") private String url;
}
