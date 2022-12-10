package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.domain.Album;
import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final JsonPlaceHolderServiceClient holderServiceClient;

    @Override
    public List<Album> getAllAlbums() {
        return holderServiceClient.getAlbums();
    }

    @Override
    public List<Album> getAlbumsByUser(Long id) {
        return holderServiceClient.getAlbumsByUser( id);
    }
}
