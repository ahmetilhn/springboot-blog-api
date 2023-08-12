package com.ahmetilhan.blogapi.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PostModel{
    @Id
    private String id;
    private Object object;
    @Getter
    private final String content;
    @Getter
    private final int view_count;
    @Getter
    private final int like_count;

    public PostModel(String content, int view_count, int like_count) {
        this.content = content;
        this.view_count = view_count;
        this.like_count = like_count;
    }

}
