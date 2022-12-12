package com.accenture.accenture.entrypoint.service;

import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.CommentService;
import com.accenture.accenture.entryPoint.service.PostService;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CommentServiceImplTest {

    @Mock
    private CommentService commentService;

    @Mock
    private JsonPlaceHolderServiceClient holderServiceClient;

    @Mock
    private PostService postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(holderServiceClient.getComments()).thenReturn(MockFactory.commentListMockFactory());
        Mockito.when(holderServiceClient.getCommentsById(ArgumentMatchers.anyLong())).thenReturn(MockFactory.commentListMockFactory());
        Mockito.when(holderServiceClient.getCommentsByPostId(ArgumentMatchers.anyLong())).thenReturn(MockFactory.commentListMockFactory());
        Mockito.when(postService.getPostsByUserId(ArgumentMatchers.anyLong())).thenReturn(MockFactory.postListMockFactory());
    }

    @Test
    void WhenCallServiceGetAllCommentsResponseValid(){
        Assertions.assertNotNull(commentService.getAllComments());
    }

    @Test
    void WhenCallServiceGetCommentByIdResponseValid(){
        Assertions.assertNotNull(commentService.getCommentsByID(ArgumentMatchers.anyLong()));
    }

    @Test
    void WhenCallServiceGetCommentsByPOstIdResponseValid(){
        Assertions.assertNotNull(commentService.getCommentsByPostId(ArgumentMatchers.anyLong()));
    }

    @Test
    void WhenCallServiceGetCPostByUserIdResponseValid(){
        Assertions.assertNotNull(commentService.getCommentsByUserIdOrName(ArgumentMatchers.anyLong(),ArgumentMatchers.anyString()));
    }


}
