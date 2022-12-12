package com.accenture.accenture.jpa.repository;



import com.accenture.accenture.jpa.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class in charge to implement the persistence of the DB
 * @author Iván García
 * @version v1
 */
@Repository
public interface PermissionRepository extends JpaRepository <Permission, Long> {

    /**
     * Call the DB
     * and filter by album Id
     * response list of Permission
     * @param id albumId
     * @returns List<Album> list of albums
     */
    List<Permission> findByAlbumId(Long id);


}
