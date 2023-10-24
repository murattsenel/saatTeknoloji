package com.muratcode.springcrudapi.repository;

import com.muratcode.springcrudapi.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    @Query(value= "select*" +
            "from route where route.id=id"
            , nativeQuery = true)
    Route findRouteById(@Param("id") Long id);
}
