package com.muratcode.springcrudapi.repository;

import com.muratcode.springcrudapi.domain.Flight;
import com.muratcode.springcrudapi.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query(value= "select *\n" +
            "from flight where " +
            "((:status is null) or (:status = flight.status))"
            , nativeQuery = true)
    List<Flight> findFlightByStatus(@Param("status") String status);

}
