package com.ahmetilhan.blogapi.controller;

import com.ahmetilhan.blogapi.model.PostModel;
import com.ahmetilhan.blogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/posts")
public class PostController {
    @Autowired
    private PostService service;
    @GetMapping
    public ResponseEntity<List<PostModel>> getAllPosts(){
        List<PostModel> posts = service.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody PostModel payload){
        service.create(payload);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getPostById(@PathVariable String id){
        Optional<PostModel> post = service.getPostById(id);
        if(post.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else  {
            return  new ResponseEntity<>(post, HttpStatus.OK);
        }
    }
    @PutMapping
    public  ResponseEntity<?> update(@RequestBody PostModel payload){
        if(payload.getId() == null){
            return new ResponseEntity<>("ID is must required", HttpStatus.BAD_REQUEST);
        }
        try {
            service.updatePost(payload);
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
