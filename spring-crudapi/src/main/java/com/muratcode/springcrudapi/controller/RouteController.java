package com.muratcode.springcrudapi.controller;

import com.muratcode.springcrudapi.domain.Airport;
import com.muratcode.springcrudapi.domain.Route;
import com.muratcode.springcrudapi.domain.RouteDTO;
import com.muratcode.springcrudapi.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/route")
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    public RouteDTO save(@RequestBody RouteDTO routeDTO) {
        return routeService.save(routeDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        routeService.delete(id);
    }

    @GetMapping("/getall")
    public List<RouteDTO> getAll() {
        return routeService.getAll();
    }

    @GetMapping("/{id}")
    public RouteDTO findById(@PathVariable Long id) throws Exception {
        return routeService.findById(id);
    }
}
