package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.Post;

import java.util.List;

public interface PostService {

    List<Post> getPostsByUserId(Long id);


}
