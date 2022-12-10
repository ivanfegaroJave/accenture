package com.accenture.accenture.entryPoint.controller;

import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.crosscuting.constants.ResourceEndpoint;
import com.accenture.accenture.domain.User;
import com.accenture.accenture.entryPoint.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = Constants.CROSS_ORIGIN)
@RequestMapping(value = ResourceEndpoint.USER)
public class UserController {

    private final UserService userService;


    @GetMapping(value = ResourceEndpoint.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = ResourceEndpoint.ID_PARAMETER, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping(value = ResourceEndpoint.ALBUM_BY_PERMISSION, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsersByAlbumByPermission(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUSerByPermissionByAlbum(id), HttpStatus.OK);
    }

}
