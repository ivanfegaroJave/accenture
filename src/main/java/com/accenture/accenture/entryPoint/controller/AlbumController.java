package com.accenture.accenture.entryPoint.controller;


import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.crosscuting.constants.ResourceEndpoint;
import com.accenture.accenture.domain.Album;
import com.accenture.accenture.entryPoint.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = Constants.CROSS_ORIGIN)
@RequestMapping(value = ResourceEndpoint.ALBUM)
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping(value = ResourceEndpoint.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }

    @GetMapping(value = ResourceEndpoint.ALBUMS_BY_USER, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Album>> getAlbumsByUser(@PathVariable Long id) {
        return new ResponseEntity<>(albumService.getAlbumsByUser(id), HttpStatus.OK);
    }
}
