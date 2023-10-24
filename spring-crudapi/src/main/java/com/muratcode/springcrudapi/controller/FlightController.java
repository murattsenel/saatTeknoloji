package com.muratcode.springcrudapi.controller;


import com.muratcode.springcrudapi.domain.Flight;
import com.muratcode.springcrudapi.domain.FlightDTO;
import com.muratcode.springcrudapi.domain.RouteDTO;
import com.muratcode.springcrudapi.mapper.ModelMapperService;
import com.muratcode.springcrudapi.repository.FlightRepository;
import com.muratcode.springcrudapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight")
public class FlightController {

    private final FlightService flightService;
    private final FlightRepository flightRepository;
    private  final ModelMapperService modelMapperService;

    @PostMapping
    public FlightDTO save(@RequestBody FlightDTO flightDTO) {
        return flightService.save(flightDTO);
    }

    @GetMapping("/{id}")
    public FlightDTO findById(@PathVariable Long id) throws Exception {
        return flightService.findById(id);
    }
  

    @GetMapping("/getall")
    public List<FlightDTO> getAll() {
        return flightService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        flightService.delete(id);
    }

}
