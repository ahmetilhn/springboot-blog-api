package com.ahmetilhan.blogapi.service;

import com.ahmetilhan.blogapi.model.PostModel;
import com.ahmetilhan.blogapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class PostService {
    @Autowired
    private PostRepository repository;
    public List<PostModel> getAllPosts(){
        return this.repository.findAll();
    }
    public void create(PostModel payload){
        PostModel post = new PostModel(payload.getContent(), payload.getView_count(), payload.getLike_count(), payload.getId());
        repository.save(post);
    }
    public Optional<PostModel> getPostById(String id){
        return repository.findById(id);
    }
    public void updatePost(PostModel payload){
        repository.findById(payload.getId()).map(oldPost -> {
            PostModel updatedPost = oldPost.update(payload);
           return  repository.save(updatedPost);
        });
    }
}
