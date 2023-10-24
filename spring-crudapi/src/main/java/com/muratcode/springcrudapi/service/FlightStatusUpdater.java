package com.muratcode.springcrudapi.service;

import com.muratcode.springcrudapi.domain.Flight;
import com.muratcode.springcrudapi.enums.Status;
import com.muratcode.springcrudapi.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FlightStatusUpdater {

    private final FlightRepository flightRepository;

    LocalDateTime currentTime = LocalDateTime.now();

    @Scheduled(fixedRate = 5000)
    public void updateFlightStatus() {

        List<Flight> departingFlights = flightRepository.findFlightByStatus("SCHEDULED");
        for (Flight flight : departingFlights) {
            if (flight.getDepartureTime().isBefore(currentTime)) {
                flight.setStatus(Status.valueOf("DEPARTED"));
                flightRepository.save(flight);
            }
        }

        List<Flight> arrivingFlights = flightRepository.findFlightByStatus("DEPARTED");
        for (Flight flight : arrivingFlights) {
            if (flight.getArrivalTime().isBefore(currentTime)) {
                flight.setStatus(Status.valueOf("ARRIVED"));
                flightRepository.save(flight);
            }
        }
    }
 }
