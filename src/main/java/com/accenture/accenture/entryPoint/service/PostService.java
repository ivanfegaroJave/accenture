package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.Post;

import java.util.List;

/**
 * Interface based in bring the data related to the posts
 * from the service Client
 * @author Iván García
 * @version v1
 */
public interface PostService {

    List<Post> getPostsByUserId(Long id);


}
