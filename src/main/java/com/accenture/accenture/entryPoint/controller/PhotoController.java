package com.accenture.accenture.entryPoint.controller;

import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.crosscuting.constants.ResourceEndpoint;

import com.accenture.accenture.domain.Photo;
import com.accenture.accenture.entryPoint.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = Constants.CROSS_ORIGIN)
@RequestMapping(value = ResourceEndpoint.PHOTO)
public class PhotoController {

    private final PhotoService photoService;

    @GetMapping(value = ResourceEndpoint.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Photo>> getAllPhotos() {
        return new ResponseEntity<>(photoService.getPhotos(), HttpStatus.OK);
    }

    @GetMapping(value = ResourceEndpoint.PHOTOS_BY_USER, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Photo>> getPhotosByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(photoService.getPhotosByUser(userId), HttpStatus.OK);
    }








}
