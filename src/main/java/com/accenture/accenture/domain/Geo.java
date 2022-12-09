package com.accenture.accenture.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Geo implements Serializable {

    private String lat;
    private String lng;


}
