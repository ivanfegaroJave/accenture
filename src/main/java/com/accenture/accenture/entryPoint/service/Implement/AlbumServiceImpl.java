package com.accenture.accenture.entryPoint.service.Implement;

import com.accenture.accenture.domain.Album;
import com.accenture.accenture.entryPoint.client.JsonPlaceHolderServiceClient;
import com.accenture.accenture.entryPoint.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class in charge to implement the logic of get the albums data
 * @author Iván García
 * @version v1
 */
@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final JsonPlaceHolderServiceClient holderServiceClient;

    /**
     * Call the service Client
     * Bring the data from the client and response list of albums
     * @returns List<Album> list of albums
     */
    @Override
    public List<Album> getAllAlbums() {
        return holderServiceClient.getAlbums();
    }

    /**
     * Call the service Client
     * Bring the data based on the id of the user
     * @param id
     * @returns List<Album> list of albums
     */
    @Override
    public List<Album> getAlbumsByUser(Long id) {
        return holderServiceClient.getAlbumsByUser( id);
    }
}
