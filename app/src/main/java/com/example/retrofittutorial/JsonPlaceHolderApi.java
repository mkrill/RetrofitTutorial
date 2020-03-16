package com.example.retrofittutorial;

import java.net.URL;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    // Only relative URL
    @GET("posts")
    // always start without "/",
    // otherwise everything after the 1st "/" in baseURL will be replaced by the @Get-Parameter
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @GET
    Call<List<Comment>> getComments(@Url String url); // can also include the base url

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    @FormUrlEncoded
    @POST
    Call<Post> createPost(@FieldMap Map<String, String> fields); // @Field parameter for passing additional lists

    @Headers({"Static-Header1: 123", "Static-Header2: 456"})
    @PUT("posts/{id}") // will completely replace server object, full object needs to be sent
    Call<Post> putPost(
            @Header("Dynamic-Header") String header,
            @Path("id") int id,
            @Body Post post);

    @PATCH("posts/{id}") // will patch only attributes sent, attributes not sent will still exist
    Call<Post> patchPost(@HeaderMap Map<String, String> headers,
                         @Path("id") int id,
                         @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
