package com.accenture.accenture.entrypoint.service;

import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.PostService;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PostServiceImplTest {


    @Mock
    private PostService postService;

    @Mock
    private JsonPlaceHolderServiceClient holderServiceClient;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(holderServiceClient.getPostByUserID(ArgumentMatchers.anyLong())).thenReturn(MockFactory.postListMockFactory());
    }

    @Test
    void WhenCallServiceGetUserResponseValid(){
        Assertions.assertNotNull(postService.getPostsByUserId(ArgumentMatchers.anyLong()));
    }


}
