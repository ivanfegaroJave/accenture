package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.Photo;
import com.accenture.accenture.domain.User;

import java.util.List;

/**
 * Interface class that describes the methods that get the data from Client photos
 *
 * @author Iván García
 * @version v1
 */
public interface PhotoService {


    List<Photo> getPhotos();

    List<Photo> getPhotosByUser( Long userId);

}
