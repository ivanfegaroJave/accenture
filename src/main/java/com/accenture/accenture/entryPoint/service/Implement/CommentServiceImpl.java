package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.domain.Comment;
import com.accenture.accenture.domain.Post;
import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.CommentService;
import com.accenture.accenture.entryPoint.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final JsonPlaceHolderServiceClient holderServiceClient;

    private final PostService postService;


    @Override
    public List<Comment> getAllComments() {
        return holderServiceClient.getComments();
    }

    @Override
    public List<Comment> getCommentsByID(Long id) {
        return holderServiceClient.getCommentsById(id);
    }

    @Override
    public List<Comment> getCommentsByPostId(Long id) {
        return holderServiceClient.getCommentsByPostId(id);
    }

    @Override
    public List<Comment> getCommentsByUserIdOrName(Long id, String name) {
        List<Comment> listCommentsByUser;
        if(id != null){
            listCommentsByUser = new ArrayList<>();
            List<Post> listPostsByUser = postService.getPostsByUserId(id);
            listPostsByUser.stream().forEach(x-> listCommentsByUser.addAll(getCommentsByPostId(x.getId())));
        }
        else {
            listCommentsByUser = holderServiceClient.getCommentsByName(name);
        }
        return listCommentsByUser;
    }
}
