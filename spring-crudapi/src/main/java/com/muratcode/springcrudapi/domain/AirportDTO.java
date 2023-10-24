package com.muratcode.springcrudapi.domain;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AirportDTO {

    private Long id;

    private String name;

    private String code;

    private String city;

    private String country;
}
