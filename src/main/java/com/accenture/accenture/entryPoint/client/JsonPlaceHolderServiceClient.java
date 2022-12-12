package com.accenture.accenture.entryPoint.client;


import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.domain.Photo;
import com.accenture.accenture.domain.User;
import com.accenture.accenture.domain.Album;
import com.accenture.accenture.domain.Comment;
import com.accenture.accenture.domain.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Class in charge to call REST client JSONPlaceHOlder
 * @author Iván García
 * @version v1
 */
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

    @GetMapping( path = Constants.COMMENTS, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Comment> getComments();

    @GetMapping( path = Constants.COMMENTS_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Comment> getCommentsById(@PathVariable(Constants.ID) Long id);

    @GetMapping( path = Constants.COMMENTS, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Comment> getCommentsByPostId(@RequestParam(Constants.POST_ID) Long id);

    @GetMapping( path = Constants.COMMENTS, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Comment> getCommentsByName(@RequestParam(Constants.NAME) String name);

    @GetMapping( path = Constants.POSTS, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Post> getPostByUserID(@RequestParam(Constants.USERID) Long id);


}
