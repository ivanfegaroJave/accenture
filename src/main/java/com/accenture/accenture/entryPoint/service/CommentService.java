package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();
    List<Comment> getCommentsByID(Long id);
    List<Comment> getCommentsByPostId(Long id);
    List<Comment> getCommentsByUserIdOrName(Long id, String name);




}
