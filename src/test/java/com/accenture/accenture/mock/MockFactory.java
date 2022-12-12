package com.accenture.accenture.mock;


import com.accenture.accenture.domain.*;
import com.accenture.accenture.jpa.entity.Permission;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class MockFactory {


    public static User userMockFactory(){
      return  User.builder().id(1)
                .address(getAddress())
                .name("John Smith")
                .phone("4323451123")
                .company(getCompany())
                .email("j@gmail.com").build();

    }

    public static Address getAddress(){
       return Address.builder().city("Ciudad de Plata")
                .street("CLL 100")
                .suite("test")
                .geo(getGeo())
                .zipcode("121212").build();
    }

    public static Geo getGeo(){
        return Geo.builder().lat("10")
                .lng("15").build();
    }

    public static Company getCompany(){
        return Company.builder()
                .name("Accenture")
                .catchPhrase("ACC")
                .bs("TEST")
                .build();
    }

    public static List<User> userListMockFactory() {
        List<User> userList = new ArrayList<>();
        userList.add(userMockFactory());
        return userList;
    }

    public static Permission permissionMockFactory(){
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setRead(true);
        permission.setWrite(true);
        permission.setUserId(1L);
        permission.setAlbumId(2L);
        return permission;
    }

    public static List<Permission> permissionListMockFactory(){
        List<Permission> permissionList = new ArrayList<>();
        permissionList.add(permissionMockFactory());
        return permissionList;
    }

    public static Post getPostMockFactory(){
       return Post.builder().id(1L)
                .userId(2L)
                .body("test")
                .title("test post")
                .build();
    }

    public static List<Post> postListMockFactory(){
        List<Post> listPost = new ArrayList<>();
        listPost.add(getPostMockFactory());
        return listPost;
    }

    public static Comment commentMockFactory(){
        return Comment.builder().id(1L)
                .email("a@gmial.com")
                .name("Test")
                .body("Este es un comentario")
                .postId(3L)
                .build();
    }

    public static List<Comment> commentListMockFactory(){
        List<Comment> listComment = new ArrayList<>();
        listComment.add(commentMockFactory());
        return listComment;
    }

    public static Photo photoMockFactory(){
      return Photo.builder().id(1)
               .title("Photo 1")
               .url("Http://url/photo")
               .albumId(2)
               .build();
    }

    public static List<Photo> photoListMockFactory(){
        List<Photo> photos = new ArrayList<>();
        photos.add(photoMockFactory());
        return photos;

    }

    public static ResponseEntity<Permission> permissionMockFactoryResponseEntity(){
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setRead(true);
        permission.setWrite(true);
        permission.setUserId(1L);
        permission.setAlbumId(2L);
        return new ResponseEntity<>(permission,HttpStatus.OK);
    }

    public static Album albumMockFactory(){
       return Album.builder().id(1L)
                .userId(2L)
                .title("TEStAlbum")
                .build();

    }

    public static List<Album> albumListMockFactory(){
        List<Album> listAlbum = new ArrayList<>();
        listAlbum.add(albumMockFactory());
        return listAlbum;
    }

}
