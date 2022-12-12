package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.domain.Album;
import com.accenture.accenture.domain.Photo;
import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class in charge to implement the logic of get the Photo's data
 * @author Iván García
 * @version v1
 */
@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

private final JsonPlaceHolderServiceClient holderServiceClient;

    /**
     * Call the service Client
     * Bring the data from the client and response list of photos
     * @returns List<Photo> list of photo
     */
    @Override
    public List<Photo> getPhotos() {
        return holderServiceClient.getPhotos();
    }

    /**
     * Call the service Client
     * Bring the data from the client based on userID
     * and response list of photos
     * @param userId
     * @returns List<Photo> list of photo
     */
    @Override
    public List<Photo> getPhotosByUser(Long userId) {
        List <Album> listAlbum = holderServiceClient.getAlbumsByUser(userId);
        List<Photo> listPhotos = new ArrayList<>();
        listAlbum.stream().forEach(x-> listPhotos.addAll(holderServiceClient.getPhotosByAlbum(x.getId())));
        return listPhotos;
    }
}
