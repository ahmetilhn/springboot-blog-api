package com.ahmetilhan.blogapi.repository;

import com.ahmetilhan.blogapi.model.PostModel;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
@Component
@Lazy
public interface PostRepository extends MongoRepository<PostModel, String> {

}
