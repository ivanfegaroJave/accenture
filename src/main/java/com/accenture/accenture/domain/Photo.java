package com.accenture.accenture.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Photo implements Serializable {

    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;



}
