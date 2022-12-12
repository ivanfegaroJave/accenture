package com.accenture.accenture.entrypoint.controller;

import com.accenture.accenture.entryPoint.controller.AlbumController;
import com.accenture.accenture.entryPoint.service.AlbumService;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class AlbumControllerTest {


    @InjectMocks
    AlbumController albumController;

    @Mock
    private AlbumService albumService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(albumService.getAllAlbums()).thenReturn(MockFactory.albumListMockFactory());
        Mockito.when(albumService.getAlbumsByUser(ArgumentMatchers.anyLong())).thenReturn(MockFactory.albumListMockFactory());

    }

    @Test
    void WhenCallServiceGetAllAlbumResponseValid(){
        Assertions.assertNotNull(albumController.getAllAlbums());
    }

    @Test
    void WhenCallServiceGetAlbumByUserResponseValid(){
        Assertions.assertNotNull(albumController.getAlbumsByUser(ArgumentMatchers.anyLong()));
    }


}
