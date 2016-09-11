package com.cafarelli.githubrepos.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Repo implements Serializable {
    @SerializedName("name")
    public String name;
    @SerializedName("description")
    public String description;
}
