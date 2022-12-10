package com.accenture.accenture.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Builder
public class Post implements Serializable {

    private Long id;
    private long userId;
    private String title;
    private String body;

}
