package com.nerd.simpleretrofit;

import java.util.List;

public class Post {
    int userId;
    int id;
    String title;
    String body;

    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    List<Post> posts;
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
