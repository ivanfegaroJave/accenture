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


/**
 * Class in charge to implement the logic of get the comments data
 * @author Iván García
 * @version v1
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final JsonPlaceHolderServiceClient holderServiceClient;

    private final PostService postService;


    /**
     * Call the service Client
     * Bring the data from the client and response list of comments
     * @returns List<Comments> list of comments
     */
    @Override
    public List<Comment> getAllComments() {
        return holderServiceClient.getComments();
    }

    /**
     * Call the service Client
     * Bring the data from the client and response list of comments
     * based on id's comments
     * @param id
     * @returns List<Album> list of albums
     */
    @Override
    public List<Comment> getCommentsByID(Long id) {
        return holderServiceClient.getCommentsById(id);
    }

    /**
     * Call the service Client
     * Bring the data from the client and response list of comments
     * based on id's Post
     * @param id post Id
     * @returns List<Album> list of albums
     */
    @Override
    public List<Comment> getCommentsByPostId(Long id) {
        return holderServiceClient.getCommentsByPostId(id);
    }

    /**
     * Call the service Client
     * and filter by name or userId
     * response list of comments
     * @param id userId
     * @param name name
     * @returns List<Album> list of albums
     */
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
