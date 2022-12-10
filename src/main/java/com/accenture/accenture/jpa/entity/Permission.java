package com.accenture.accenture.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
@Data
@Entity
@Table(name = "PERMISSION", uniqueConstraints = @UniqueConstraint(columnNames = { "USER_ID", "ALBUM_ID" }))
public class Permission implements Serializable {

    private static final long serialVersionUID = 3215833037118051878L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "ALBUM_ID", nullable = false)
    private Long albumId;

    @Column(name = "READ", nullable = false)
    private Boolean read;

    @Column(name = "WRITE", nullable = false)
    private Boolean write;




}
