package com.accenture.accenture.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Builder
public class Address implements Serializable {

    private String street;
    private String city;
    private String suite;
    private String zipcode;
    private Geo geo;

}
