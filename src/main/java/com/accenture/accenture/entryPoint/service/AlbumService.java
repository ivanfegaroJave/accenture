package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.Album;

import java.util.List;

/**
 * Interface based in bring the data related to the albums
 * from the service Client
 * @author Iván García
 * @version v1
 */
public interface AlbumService {

    List<Album> getAllAlbums();

    List<Album> getAlbumsByUser(Long id);

}
