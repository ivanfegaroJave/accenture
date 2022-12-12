package com.accenture.accenture.entrypoint.service;

import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.Implement.UserServiceImpl;
import com.accenture.accenture.entryPoint.service.PermissionService;
import com.accenture.accenture.jpa.repository.PermissionRepository;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class UserServiceImplTest {


    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private JsonPlaceHolderServiceClient holderServiceClient;

    @Mock
    private PermissionRepository permissionRepository;

    @Mock
    private PermissionService permissionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(holderServiceClient.getUsers()).thenReturn(MockFactory.userListMockFactory());
        Mockito.when(holderServiceClient.getUserById(ArgumentMatchers.anyLong())).thenReturn(MockFactory.userMockFactory());
        Mockito.when(permissionRepository.findByAlbumId(ArgumentMatchers.anyLong())).thenReturn(MockFactory.permissionListMockFactory());
        Mockito.when(permissionService.findByAlbumId(ArgumentMatchers.anyLong())).thenReturn(MockFactory.permissionListMockFactory());


    }

    @Test
    void WhenCallServiceGetUserResponseValid(){
        Assertions.assertNotNull(userService.getUsers());
    }

    @Test
    void WhenCallServiceGetUserByIdResponseValid(){
        Assertions.assertNotNull(userService.getUserById(ArgumentMatchers.anyLong()));
    }

    @Test
    void WhenCallServiceGetUSerByPermissionByAlbumResponseValid(){
        Assertions.assertNotNull(userService.getUSerByPermissionByAlbum(ArgumentMatchers.anyLong()));
    }



}
