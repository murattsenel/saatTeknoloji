package com.muratcode.springcrudapi.mapper;

import com.muratcode.springcrudapi.domain.Flight;
import com.muratcode.springcrudapi.domain.FlightDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public FlightMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FlightDTO convertToDTO(Flight flight) {
        return modelMapper.map(flight, FlightDTO.class);
    }

    public Flight convertToEntity(FlightDTO flightDTO) {
        return modelMapper.map(flightDTO, Flight.class);
    }
}
