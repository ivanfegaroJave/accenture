package com.accenture.accenture.entrypoint.controller;

import com.accenture.accenture.entryPoint.controller.PhotoController;
import com.accenture.accenture.entryPoint.service.PhotoService;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class PhotoControllerTest {


    @InjectMocks
    private PhotoController photoController;

    @Mock
    private PhotoService photoService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(photoService.getPhotos()).thenReturn(MockFactory.photoListMockFactory());
        Mockito.when((photoService.getPhotosByUser(ArgumentMatchers.anyLong()))).thenReturn(MockFactory.photoListMockFactory());

    }

    @Test
    void WhenCallServiceGetPhotosResponseValid(){
        Assertions.assertNotNull(photoController.getAllPhotos());
    }

    @Test
    void WhenCallServiceGetPhotosByUserResponseValid(){
        Assertions.assertNotNull(photoController.getPhotosByUser(ArgumentMatchers.anyLong()));
    }

}
