package com.accenture.accenture.entryPoint.client;


import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.domain.Album;
import com.accenture.accenture.domain.Photo;
import com.accenture.accenture.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient(url = "${services.holder}", name= Constants.JSON_CLIENT)
public interface JsonPlaceHolderServiceClient {


    @GetMapping( path = "${services.photos}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Photo> getPhotos();

    @GetMapping( path = Constants.PHOTOS_BY_ALBUM, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Photo> getPhotosByAlbum(@PathVariable(Constants.ID) Long id);

    @GetMapping( path = "${services.users}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<User> getUsers();

    @GetMapping( path = Constants.USER_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    User getUserById(@PathVariable Long id);

    @GetMapping( path = "${services.albums}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Album> getAlbums();

    @GetMapping( path = Constants.ALBUMS_BY_USER, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Album> getAlbumsByUser(@PathVariable(Constants.ID) Long id);




}
