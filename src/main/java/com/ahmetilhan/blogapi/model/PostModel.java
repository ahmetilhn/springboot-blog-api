package com.ahmetilhan.blogapi.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PostModel{
    @Id
    private String id;
    private final String content;

    public String getContent() {
        return content;
    }

    public int getView_count() {
        return view_count;
    }

    public int getLike_count() {
        return like_count;
    }

    private final int view_count;
    private final int like_count;

    public PostModel(String content, int view_count, int like_count) {
        this.content = content;
        this.view_count = view_count;
        this.like_count = like_count;
    }

}
