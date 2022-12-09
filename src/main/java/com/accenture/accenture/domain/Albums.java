package com.accenture.accenture.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Albums implements Serializable {

    private int userId;
    private int id;

    private String title;
    private String body;


}
