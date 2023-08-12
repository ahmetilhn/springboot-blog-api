package com.ahmetilhan.blogapi.service;

import com.ahmetilhan.blogapi.model.PostModel;
import com.ahmetilhan.blogapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class PostService {
    @Autowired
    private PostRepository repository;
    public List<PostModel> getAllPosts(){
        return this.repository.findAll();
    }
    public void create(PostModel payload){
        PostModel post = new PostModel(payload.getContent(), payload.getView_count(), payload.getLike_count());
        repository.save(post);
    }
}
