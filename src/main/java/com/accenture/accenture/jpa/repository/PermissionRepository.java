package com.accenture.accenture.jpa.repository;



import com.accenture.accenture.jpa.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository <Permission, Long> {

    List<Permission> findByAlbumId(Long id);


}
