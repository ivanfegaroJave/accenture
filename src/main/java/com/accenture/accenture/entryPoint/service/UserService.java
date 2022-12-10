package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.User;

import java.util.List;

/**
 * Interface class that describes the methods that get the data from Client
 *
 * @author Iván García
 * @version v1
 */

public interface UserService {

     /**
      * Interface of the method that  bring all the data from client users
      */

     List<User> getUsers();

     User getUserById(Long id);

     List<User> getUSerByPermissionByAlbum(Long id);

}
