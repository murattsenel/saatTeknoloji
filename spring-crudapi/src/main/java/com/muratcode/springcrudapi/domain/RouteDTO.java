package com.muratcode.springcrudapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class RouteDTO {

    private Long id;

    private AirportDTO source;

    private AirportDTO destination;

    private int distanceInMiles;
}
