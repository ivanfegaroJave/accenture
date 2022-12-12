package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.domain.User;
import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.PermissionService;
import com.accenture.accenture.entryPoint.service.UserService;
import com.accenture.accenture.jpa.entity.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class in charge to implement the logic of get the users data
 * @author Iván García
 * @version v1
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final JsonPlaceHolderServiceClient  holderServiceClient;

    private final PermissionService permissionService;



    /**
     * Get the detail of users
     * @returns List<User>
     */
    public List<User> getUsers() {
        return holderServiceClient.getUsers();
    }

    /**
     * Call the service Client
     * Bring the data from the client and response User
     * based on id's user
     * @param id
     * @returns User
     */
    @Override
    public User getUserById(Long id) {
        return holderServiceClient.getUserById(id);
    }

    /**
     * Call the service Client
     * Bring the data from the client and response list of user
     * based on id's user
     * @param id
     * @returns List<User> list of user
     */
    public List<User> getUSerByPermissionByAlbum(Long id){
        List<Permission> listPermission = permissionService.findByAlbumId(id);
        List<User> listUsers = new ArrayList<>();
        listPermission.stream().forEach(x-> listUsers.add(getUserById(x.getUserId())));
        return  listUsers;
    }



}
