package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.jpa.entity.Permission;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PermissionService {


    List<Permission> getAllPermissions();

    Permission getById(Long id);

    ResponseEntity <Permission>savePermission(Permission permission);

    ResponseEntity <Permission> updatePermission(Long id, Permission permission);

    List<Permission> findByAlbumId(Long albumId);


}
