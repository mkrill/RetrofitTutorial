package com.example.retrofittutorial;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Post {

    private int userId;
    private int id;
    private String title;

    @SerializedName("body")
    private String text;

}
