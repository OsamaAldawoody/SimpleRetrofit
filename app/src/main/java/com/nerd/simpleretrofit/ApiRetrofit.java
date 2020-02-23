package com.nerd.simpleretrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiRetrofit {
    @GET("posts/{id}")
    public Call<Post> getPost(@Path("id") int postId);

    @POST("posts")
    public Call<Post> postObject(@Body Post post);

    @POST("posts")
    public Call<Post> postHashMap(@Body HashMap<Object,Object> hashMap);
}
