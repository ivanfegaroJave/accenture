package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.Comment;

import java.util.List;

/**
 * Interface based in bring the data related to the comments
 * from the service Client
 * @author Iván García
 * @version v1
 */
public interface CommentService {

    List<Comment> getAllComments();
    List<Comment> getCommentsByID(Long id);
    List<Comment> getCommentsByPostId(Long id);
    List<Comment> getCommentsByUserIdOrName(Long id, String name);




}
