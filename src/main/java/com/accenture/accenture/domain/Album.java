package com.accenture.accenture.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Album implements Serializable {

    private Long userId;
    private Long id;

    private String title;


}
