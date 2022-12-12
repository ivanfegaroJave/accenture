package com.accenture.accenture.entrypoint.controller;

import com.accenture.accenture.entryPoint.controller.CommentController;
import com.accenture.accenture.entryPoint.service.CommentService;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class CommentControllerTest {


    @InjectMocks
    private CommentController commentController;

    @Mock
    private CommentService commentService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(commentService.getAllComments()).thenReturn(MockFactory.commentListMockFactory());
        Mockito.when(commentService.getCommentsByID(ArgumentMatchers.anyLong())).thenReturn(MockFactory.commentListMockFactory());
        Mockito.when(commentService.getCommentsByUserIdOrName(ArgumentMatchers.anyLong(),ArgumentMatchers.anyString())).thenReturn(MockFactory.commentListMockFactory());

    }

    @Test
    void WhenCallServiceGetAllCommentsResponseValid(){
        Assertions.assertNotNull(commentController.getAllComments());
    }

    @Test
    void WhenCallServiceGetCommentsByIdResponseValid(){
        Assertions.assertNotNull(commentController.getCommentsById(ArgumentMatchers.anyLong()));
    }
    @Test
    void WhenCallServiceGetCommentsByUserIdOrNameResponseValid(){
        Assertions.assertNotNull(commentController.getCommentsByUserIdOrName(ArgumentMatchers.anyLong(),ArgumentMatchers.anyString()));
    }



}
