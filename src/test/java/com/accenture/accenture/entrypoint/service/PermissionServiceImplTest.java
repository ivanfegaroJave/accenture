package com.accenture.accenture.entrypoint.service;


import com.accenture.accenture.entryPoint.service.Implement.PermissionServiceImpl;
import com.accenture.accenture.jpa.repository.PermissionRepository;
import com.accenture.accenture.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

public class PermissionServiceImplTest {


    @InjectMocks
    private PermissionServiceImpl permissionService;

    @Mock
    private PermissionRepository permissionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(permissionRepository.findAll()).thenReturn(MockFactory.permissionListMockFactory());
        Mockito.when(permissionRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(MockFactory.permissionMockFactory()));
        Mockito.when(permissionRepository.save(MockFactory.permissionMockFactory())).thenReturn(MockFactory.permissionMockFactory());
        Mockito.when(permissionRepository.findByAlbumId(ArgumentMatchers.anyLong())).thenReturn(MockFactory.permissionListMockFactory());
    }

    @Test
    void WhenCallServiceGetAllPermissionResponseValid(){
        Assertions.assertNotNull(permissionService.getAllPermissions());
    }

    @Test
    void WhenCallServiceGetPermissionByIdResponseValid(){
        Assertions.assertNotNull(permissionService.getById(ArgumentMatchers.anyLong()));
    }

    @Test
    void WhenCallServiceSavePermissionResponseValid(){
        Assertions.assertNotNull(permissionService.savePermission(MockFactory.permissionMockFactory()));
    }

    @Test
    void WhenCallServiceUpdatePermissionResponseValid(){
        Assertions.assertNotNull(permissionService.updatePermission(ArgumentMatchers.anyLong(),MockFactory.permissionMockFactory()));
    }

    @Test
    void WhenCallServiceFindByAlbumResponseValid(){
        Assertions.assertNotNull(permissionService.findByAlbumId(ArgumentMatchers.anyLong()));
    }




}
