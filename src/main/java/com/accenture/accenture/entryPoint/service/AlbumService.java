package com.accenture.accenture.entryPoint.service;

import com.accenture.accenture.domain.Album;

import java.util.List;

public interface AlbumService {

    List<Album> getAllAlbums();

    List<Album> getAlbumsByUser(Long id);

}
