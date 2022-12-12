package com.accenture.accenture.crosscuting.constants;
/**
 * Class that help to declare the constants
 *
 * @author Iván García
 * @version 1.0.0
 */

public class Constants {

    public Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CROSS_ORIGIN = "*";
    public static final String JSON_CLIENT = "jsonPlaceHolderServiceClient";

    public static final String ALBUMS_BY_USER = "/users/{id}/albums";
    public static final String COMMENTS = "/comments";
    public static final String POSTS = "/posts";
    public static final String NAME = "name";
    public static final String USERID = "userId";
    public static final String COMMENTS_BY_ID = "/comments/{id}";
    public static final String PHOTOS_BY_ALBUM = "/albums/{id}/photos";
    public static final String USER_ID = "/users/{id}";
    public static final String ID = "id";
    public static final String NOT_EXIST = "Client doesn't exist with id: ";
    public static final String POST_ID = "postId";




}
