package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.domain.Post;
import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final JsonPlaceHolderServiceClient holderServiceClient;


    @Override
    public List<Post> getPostsByUserId(Long id) {
        return holderServiceClient.getPostByUserID(id);
    }
}
