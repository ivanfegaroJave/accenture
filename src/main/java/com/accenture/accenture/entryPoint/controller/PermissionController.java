package com.accenture.accenture.entryPoint.controller;

import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.crosscuting.constants.ResourceEndpoint;
import com.accenture.accenture.entryPoint.service.PermissionService;
import com.accenture.accenture.jpa.entity.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



    @PostMapping(value = ResourceEndpoint.CREATE_PERMISSION,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Permission> createPermission(@RequestBody Permission permission ) {
            return permissionService.savePermission(permission);
    }

    @PutMapping(value = ResourceEndpoint.ID_PARAMETER,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Permission> updatePermission(@PathVariable(Constants.ID) Long id ,
                                                        @RequestBody Permission permission ) {
        return permissionService.updatePermission(id,permission);
    }




}
