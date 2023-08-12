package com.ahmetilhan.blogapi.controller;

import com.ahmetilhan.blogapi.model.PostModel;
import com.ahmetilhan.blogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {
    @Autowired
    private PostService service;
    @GetMapping
    public List<PostModel> getAllPosts(){
        return service.getAllPosts();
    }
    @PostMapping
    public void create(@RequestBody PostModel payload){
        service.create(payload);
    }
}
