package com.accenture.accenture.entryPoint.client;


import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.domain.Albums;
import com.accenture.accenture.domain.Photo;
import com.accenture.accenture.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@FeignClient(url = "${services.holder}", name= Constants.JSON_CLIENT)
public interface JsonPlaceHolderServiceClient {


    @GetMapping( path = "${services.photos}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Photo> getPhotos();

    @GetMapping( path = "${services.users}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<User> getUsers();

    @GetMapping( path = "${services.albums}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Albums> getAlbums();



}
