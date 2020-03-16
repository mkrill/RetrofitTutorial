package com.example.retrofittutorial;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Post {

    private int userId;
    private Integer id;
    private String title;

    @SerializedName("body")
    private String text;

    public Post(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }
}
