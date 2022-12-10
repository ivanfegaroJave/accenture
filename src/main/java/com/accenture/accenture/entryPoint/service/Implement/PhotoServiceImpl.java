package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.domain.Album;
import com.accenture.accenture.domain.Photo;
import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

private final JsonPlaceHolderServiceClient holderServiceClient;

    @Override
    public List<Photo> getPhotos() {
        return holderServiceClient.getPhotos();
    }

    @Override
    public List<Photo> getPhotosByUser(Long userId) {
        List <Album> listAlbum = holderServiceClient.getAlbumsByUser(userId);
        List<Photo> listPhotos = new ArrayList<>();
        listAlbum.stream().forEach(x-> listPhotos.addAll(holderServiceClient.getPhotosByAlbum(x.getId())));
        return listPhotos;
    }
}
