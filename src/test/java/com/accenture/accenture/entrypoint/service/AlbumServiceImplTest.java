package com.accenture.accenture.entrypoint.service;

import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.AlbumService;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class AlbumServiceImplTest {

    @Mock
    private AlbumService albumService;
    @Mock
    private JsonPlaceHolderServiceClient holderServiceClient;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(holderServiceClient.getAlbums()).thenReturn(MockFactory.albumListMockFactory());
        Mockito.when(holderServiceClient.getAlbumsByUser(ArgumentMatchers.anyLong())).thenReturn(MockFactory.albumListMockFactory());
    }

    @Test
    void WhenCallServiceGetAllAlbumsResponseValid(){
        Assertions.assertNotNull(albumService.getAllAlbums());
    }

    @Test
    void WhenCallServiceGetAlbumByUSerResponseValid(){
        Assertions.assertNotNull(albumService.getAlbumsByUser(ArgumentMatchers.anyLong()));
    }

}
