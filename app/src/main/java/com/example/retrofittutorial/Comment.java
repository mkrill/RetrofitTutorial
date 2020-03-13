package com.example.retrofittutorial;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Comment {

    private int postId;
    private int id;
    private String name;
    private String email;

    @SerializedName("body")
    private String text;


}
