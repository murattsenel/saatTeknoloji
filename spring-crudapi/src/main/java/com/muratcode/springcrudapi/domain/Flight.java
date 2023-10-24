package com.muratcode.springcrudapi.domain;

import com.muratcode.springcrudapi.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Getter
@Setter
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_number")
    private String flightNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    Route route;

    @Column(name = "price")
    private double price;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "capacity")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

/*    public void getStatusMap(Map<String, String> statusMap) {
        if (statusMap!=null){
            this.status= Status.fromValue(statusMap.get("value"));
        }
    }*/
}
