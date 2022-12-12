package com.accenture.accenture.entrypoint.controller;

import com.accenture.accenture.entryPoint.controller.PermissionController;
import com.accenture.accenture.entryPoint.service.PermissionService;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class PermissionControllerTest {

    @InjectMocks
    private PermissionController permissionController;

    @Mock
    private PermissionService permissionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(permissionService.getAllPermissions()).thenReturn(MockFactory.permissionListMockFactory());
        Mockito.when(permissionService.savePermission(MockFactory.permissionMockFactory())).thenReturn(MockFactory.permissionMockFactoryResponseEntity());

    }

    @Test
    void WhenCallServiceGetAllPermissionResponseValid(){
        Assertions.assertNotNull(permissionController.getAllPermissions());
    }

    @Test
    void WhenCallServiceCreatePermissionResponseValid(){
        Assertions.assertNotNull(permissionController.createPermission(MockFactory.permissionMockFactory()));
    }

}
