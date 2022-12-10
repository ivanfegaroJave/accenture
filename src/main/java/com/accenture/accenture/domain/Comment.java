package com.accenture.accenture.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Comment implements Serializable {

    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;

}
