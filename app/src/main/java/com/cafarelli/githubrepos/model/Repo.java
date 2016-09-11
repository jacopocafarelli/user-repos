package com.cafarelli.githubrepos.model;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("name") public String name;
    @SerializedName("description") public String description;
    @SerializedName("html_url") public String url;
}
