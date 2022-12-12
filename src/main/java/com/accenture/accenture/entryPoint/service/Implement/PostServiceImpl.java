package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.domain.Post;
import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Class in charge to implement the logic of get the Posts data
 * @author Iván García
 * @version v1
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final JsonPlaceHolderServiceClient holderServiceClient;

    /**
     * Call the service Client
     * Bring the data from the client based on userID
     * and response list of posts
     * @param id
     * @returns List<Post> list of post
     */
    @Override
    public List<Post> getPostsByUserId(Long id) {
        return holderServiceClient.getPostByUserID(id);
    }
}
