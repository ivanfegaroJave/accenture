package com.accenture.accenture.entrypoint.controller;

import com.accenture.accenture.entryPoint.controller.UserController;
import com.accenture.accenture.entryPoint.service.Implement.UserServiceImpl;
import com.accenture.accenture.entryPoint.service.PermissionService;
import com.accenture.accenture.jpa.repository.PermissionRepository;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    @Mock
    private PermissionService permissionService;

    @Mock
    private PermissionRepository permissionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(userService.getUsers()).thenReturn(MockFactory.userListMockFactory());
        Mockito.when(userService.getUserById(ArgumentMatchers.anyLong())).thenReturn(MockFactory.userMockFactory());
        Mockito.when(permissionRepository.findByAlbumId(ArgumentMatchers.anyLong())).thenReturn(MockFactory.permissionListMockFactory());
        Mockito.when(permissionService.findByAlbumId(ArgumentMatchers.anyLong())).thenReturn(MockFactory.permissionListMockFactory());
    }

    @Test
    void WhenCallServiceGetUserResponseValid(){
        Assertions.assertNotNull(userController.getUsers());
    }

    @Test
    void WhenCallServiceGetUserByIdResponseValid(){
        Assertions.assertNotNull(userController.getUserById(ArgumentMatchers.anyLong()));
    }

    @Test
    void WhenCallServiceGetUserByAlbumByPermissionResponseValid(){
        Assertions.assertNotNull(userController.getUsersByAlbumByPermission(ArgumentMatchers.anyLong()));
    }

}
