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

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final JsonPlaceHolderServiceClient  holderServiceClient;

    private final PermissionService permissionService;



    /**
     * Get the detail of user
     * @returns List of the all users
     */
    public List<User> getUsers() {
        return holderServiceClient.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return holderServiceClient.getUserById(id);
    }

    public List<User> getUSerByPermissionByAlbum(Long id){
        List<Permission> listPermission = permissionService.findByAlbumId(id);
        List<User> listUsers = new ArrayList<>();
        listPermission.stream().forEach(x-> listUsers.add(getUserById(x.getUserId())));
        return  listUsers;
    }



}
