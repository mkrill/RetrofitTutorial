package com.example.retrofittutorial;

import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    // Only relative URL
    @GET("posts")
    Call<List<Post>> getPosts();
}
