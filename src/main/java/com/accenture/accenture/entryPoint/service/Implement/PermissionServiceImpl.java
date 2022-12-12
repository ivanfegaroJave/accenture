package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.crosscuting.exceptions.ValidationException;
import com.accenture.accenture.domain.User;
import com.accenture.accenture.entryPoint.service.PermissionService;
import com.accenture.accenture.entryPoint.service.UserService;
import com.accenture.accenture.jpa.entity.Permission;
import com.accenture.accenture.jpa.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;


    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getById(Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(()-> new ValidationException(Constants.NOT_EXIST + id));
    }

    @Override
    public ResponseEntity <Permission> savePermission(Permission permission) {
        return ResponseEntity.ok(permissionRepository.save(permission));
    }


    @Override
    public ResponseEntity <Permission> updatePermission(Long id,Permission permission) {
        Permission findPermission = getById(id);


        return ResponseEntity.ok(permissionRepository.save(findPermission));
    }

    @Override
    public List<Permission> findByAlbumId(Long albumId) {
       return permissionRepository.findByAlbumId(albumId);
    }

}
