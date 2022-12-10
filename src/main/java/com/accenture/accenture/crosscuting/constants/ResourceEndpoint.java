package com.accenture.accenture.crosscuting.constants;
/**
 * Class that help to initialize the endPoint for each service
 *
 * @author Iván García
 * @version 1.0.0
 */
public class ResourceEndpoint {

    public ResourceEndpoint() {
        super();
    }

    public static final String API = "api/v1/";
    public static final String USER = API + "users";
    public static final String PHOTO = API + "photos";
    public static final String ALBUM = API + "albums";
    public static final String PERMISSION = API + "permission";
    public static final String PATH = "/";

    public static final String ALBUMS_BY_USER= "albumsByUser/{id}";
    public static final String PHOTOS_BY_USER = "/users/{userId}/photos";
    public static final String CREATE_PERMISSION = "/create";
    public static final String ID_PARAMETER = "/{id}";
    public static final String ALBUM_BY_PERMISSION = "/albums/{id}/permission";





}
