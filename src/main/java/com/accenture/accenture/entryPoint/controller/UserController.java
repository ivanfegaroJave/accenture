package com.accenture.accenture.entryPoint.controller;

import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.crosscuting.constants.ResourceEndpoint;
import com.accenture.accenture.domain.User;
import com.accenture.accenture.entryPoint.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * Class in charge to expose User services
 * @author Iván García
 * @version v1
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = Constants.CROSS_ORIGIN)
@RequestMapping(value = ResourceEndpoint.USER)
public class UserController {

    private final UserService userService;

    /**
     * información del servicio se tiene que poder acceder a través de nuestra API a:
     * 1 Los usuarios
     * */
    @GetMapping(value = ResourceEndpoint.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = ResourceEndpoint.ID_PARAMETER, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
    /**
     Para persistir y consumir esta información nueva el sistema debe permitir:
     3. Traer todos los usuarios que tienen un permiso determinado respecto a un
     álbum específico.
     * */
    @GetMapping(value = ResourceEndpoint.ALBUM_BY_PERMISSION, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsersByAlbumByPermission(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUSerByPermissionByAlbum(id), HttpStatus.OK);
    }

}
