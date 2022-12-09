package com.accenture.accenture.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Company implements Serializable {

    private String name;
    private String catchPhrase;
    private String bs;
}
