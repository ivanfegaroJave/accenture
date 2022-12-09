package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.domain.User;
import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final JsonPlaceHolderServiceClient  holderServiceClient;


    /**
     * Get the detail of user
     * @returns List of the all users
     */
    public List<User> getUsers() {
        return holderServiceClient.getUsers();
    }


}
