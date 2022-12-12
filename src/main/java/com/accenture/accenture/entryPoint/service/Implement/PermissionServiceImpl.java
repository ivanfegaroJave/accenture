package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.crosscuting.exceptions.ValidationException;
import com.accenture.accenture.entryPoint.service.PermissionService;
import com.accenture.accenture.jpa.entity.Permission;
import com.accenture.accenture.jpa.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class in charge to implement the logic of permissions
 * Save and Read the data from H2 DB
 * @author Iván García
 * @version v1
 */
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    /**
     * Call the DB and
     * Bring the data from the DB, response list of permissions
     * @returns List<Permission> list of permissions
     */
    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    /**
     * Call the DB
     * Bring the data based on the id of the permission
     * @param id
     * @returns List<Permission> list of permissions
     */
    @Override
    public Permission getById(Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(()-> new ValidationException(Constants.NOT_EXIST + id));
    }

    /**
     * Save the data on DB
     * @param permission
     * @returns List<Permission> list of permissions
     */
    @Override
    public ResponseEntity <Permission> savePermission(Permission permission) {
        return ResponseEntity.ok(permissionRepository.save(permission));
    }

    /**
     * update the permissions on DB
     * @param permission
     * @returns List<Permission> list of permissions
     */
    @Override
    public ResponseEntity <Permission> updatePermission(Long id,Permission permission) {
        Permission findPermission = getById(id);

        if(findPermission.getRead() != permission.getRead())
            findPermission.setRead(permission.getRead());

        if(findPermission.getWrite() != permission.getWrite())
            findPermission.setWrite(permission.getWrite());

        return ResponseEntity.ok(permissionRepository.save(findPermission));
    }

    /**
     * find  the permissions on DB based on album's id
     * @param albumId
     * @returns List<Permission> list of permissions
     */
    @Override
    public List<Permission> findByAlbumId(Long albumId) {
       return permissionRepository.findByAlbumId(albumId);
    }

}
