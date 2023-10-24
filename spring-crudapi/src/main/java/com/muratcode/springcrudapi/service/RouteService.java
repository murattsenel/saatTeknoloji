package com.muratcode.springcrudapi.service;

import com.muratcode.springcrudapi.domain.Airport;
import com.muratcode.springcrudapi.domain.AirportDTO;
import com.muratcode.springcrudapi.domain.Route;
import com.muratcode.springcrudapi.domain.RouteDTO;
import com.muratcode.springcrudapi.mapper.ModelMapperService;
import com.muratcode.springcrudapi.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    private  final ModelMapperService modelMapperService;


    public RouteDTO save(RouteDTO routeDTO) {
        Route route=  this.modelMapperService.forRequest().map(routeDTO,Route.class);
        return this.modelMapperService.forResponse().map(routeRepository.save(route), RouteDTO.class);
    }

    public void delete(Long id) throws Exception {
        Route route = routeRepository.findRouteById(id);
        if(route != null){
            routeRepository.deleteById(id);
        }else{
            throw new Exception("Silinmek istenen rota kaydı bulunamadı!");
        }
    }
    public RouteDTO findById(Long id) throws Exception {
        return  this.modelMapperService.forResponse().map(routeRepository.findById(id), RouteDTO.class);
    }

    public List<RouteDTO> getAll() {
        List<Route> routeList = routeRepository.findAll();
        return routeList
                .stream()
                .map(route -> this.modelMapperService.forResponse().map(route,RouteDTO.class))
                .collect(Collectors.toList());
    }
}
