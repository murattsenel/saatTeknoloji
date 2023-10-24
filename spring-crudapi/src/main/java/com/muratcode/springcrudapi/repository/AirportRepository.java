package com.muratcode.springcrudapi.repository;

import com.muratcode.springcrudapi.domain.Airport;
import com.muratcode.springcrudapi.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository  extends JpaRepository<Airport,Long> {
}
