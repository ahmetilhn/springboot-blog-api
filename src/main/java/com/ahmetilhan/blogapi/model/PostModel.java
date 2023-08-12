package com.ahmetilhan.blogapi.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class PostModel{
    @Id
    private String _id;
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

    public  String getId(){
        return  _id;
    }

    private final int view_count;
    private final int like_count;

    public PostModel(String content, int view_count, int like_count, String _id) {
        this.content = content;
        this.view_count = view_count;
        this.like_count = like_count;
        this._id = _id;
    }
    public PostModel update(PostModel payload){
        return  new PostModel(
                payload.content,
                payload.view_count,
                payload.like_count,
                payload._id
        );
    }
}
