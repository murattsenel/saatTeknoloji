package com.muratcode.springcrudapi.domain;


import com.muratcode.springcrudapi.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class FlightDTO {

    private Long id;

    private String flightNumber;

    private RouteDTO route;

    private double price;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private int capacity;

    private Status status;


}
