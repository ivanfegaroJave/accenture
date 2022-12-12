package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.Photo;
import com.accenture.accenture.domain.User;

import java.util.List;

/**
 * Interface based in bring the data related to the Photos
 * from the service Client
 * @author Iván García
 * @version v1
 */
public interface PhotoService {


    List<Photo> getPhotos();

    List<Photo> getPhotosByUser( Long userId);

}
