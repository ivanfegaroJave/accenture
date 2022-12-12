package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.User;

import java.util.List;

/**
 * Interface based in bring the data related to the users
 * from the service Client
 * @author Iván García
 * @version v1
 */
public interface UserService {

     List<User> getUsers();

     User getUserById(Long id);

     List<User> getUSerByPermissionByAlbum(Long id);

}
