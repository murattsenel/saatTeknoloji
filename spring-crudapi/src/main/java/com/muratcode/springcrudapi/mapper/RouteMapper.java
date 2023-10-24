package com.muratcode.springcrudapi.mapper;

import com.muratcode.springcrudapi.domain.Route;
import com.muratcode.springcrudapi.domain.RouteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public RouteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RouteDTO convertToDTO(Route route) {
        return modelMapper.map(route, RouteDTO.class);
    }

    public Route convertToEntity(RouteDTO routeDTO) {
        return modelMapper.map(routeDTO, Route.class);
    }
}
