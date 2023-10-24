package com.muratcode.springcrudapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    Airport source;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id")
    Airport destination;

    @Column(name = "distance_in_miles")
    private int distanceInMiles;



}
