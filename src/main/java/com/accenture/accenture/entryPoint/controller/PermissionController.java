package com.accenture.accenture.entryPoint.controller;

import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.crosscuting.constants.ResourceEndpoint;
import com.accenture.accenture.entryPoint.service.PermissionService;
import com.accenture.accenture.jpa.entity.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * Class in charge to expose Permission services
 * @author Iván García
 * @version v1
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = Constants.CROSS_ORIGIN)
@RequestMapping(value = ResourceEndpoint.PERMISSION)
public class PermissionController {


    private final PermissionService permissionService;

    @GetMapping(value = ResourceEndpoint.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Permission>> getAllPermissions() {
        return new ResponseEntity<>(permissionService.getAllPermissions(), HttpStatus.OK);
    }


    /**
     Para persistir y consumir esta información nueva el sistema debe permitir:
     1. Registrar un álbum compartido con un usuario y sus permisos.
     * */
    @PostMapping(value = ResourceEndpoint.CREATE_PERMISSION,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Permission> createPermission(@RequestBody Permission permission ) {
            return permissionService.savePermission(permission);
    }

    /**
     Para persistir y consumir esta información nueva el sistema debe permitir:
     2. Cambiar los permisos de un usuario para un álbum determinado.
     * */

    @PutMapping(value = ResourceEndpoint.ID_PARAMETER,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Permission> updatePermission(@PathVariable(Constants.ID) Long id ,
                                                        @RequestBody Permission permission ) {
        return permissionService.updatePermission(id,permission);
    }




}
