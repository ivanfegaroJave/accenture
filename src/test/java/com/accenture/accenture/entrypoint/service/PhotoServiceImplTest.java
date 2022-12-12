package com.accenture.accenture.entrypoint.service;

import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;

import com.accenture.accenture.entryPoint.service.PhotoService;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class PhotoServiceImplTest {


    @Mock
    private PhotoService photoService;

    @Mock
    private JsonPlaceHolderServiceClient holderServiceClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(holderServiceClient.getPhotos()).thenReturn(MockFactory.photoListMockFactory());
        Mockito.when(holderServiceClient.getPhotosByAlbum(ArgumentMatchers.anyLong())).thenReturn(MockFactory.photoListMockFactory());
    }

    @Test
    void WhenCallServiceGetAllPhotosResponseValid(){
        Assertions.assertNotNull(photoService.getPhotos());
    }

    @Test
    void WhenCallServiceGetPhotosByUserResponseValid(){
        Assertions.assertNotNull(photoService.getPhotosByUser(ArgumentMatchers.anyLong()));
    }


}
