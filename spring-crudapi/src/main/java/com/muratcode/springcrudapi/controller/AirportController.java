package com.muratcode.springcrudapi.controller;


import com.muratcode.springcrudapi.domain.Airport;
import com.muratcode.springcrudapi.domain.AirportDTO;
import com.muratcode.springcrudapi.domain.Flight;
import com.muratcode.springcrudapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/airport")
public class AirportController {

    private final AirportService airportService;

    @PostMapping
    public AirportDTO save(@RequestBody AirportDTO airportDTO) {
        return airportService.save(airportDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        airportService.delete(id);
    }

    @GetMapping("/getall")
    public List<AirportDTO> getAll() {
        return airportService.getAll();
    }


    @GetMapping("/{id}")
    public AirportDTO findById(@PathVariable Long id) throws Exception {
        return   airportService.findById(id);
    }
}
