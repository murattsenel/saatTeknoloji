package com.muratcode.springcrudapi.mapper;

import com.muratcode.springcrudapi.domain.Airport;
import com.muratcode.springcrudapi.domain.AirportDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper {

    private final ModelMapper modelMapper;
    public AirportMapper(ModelMapper modelMapper){

        this.modelMapper = modelMapper;
    }





    public AirportDTO convertToDTO(Airport airport) {
        return modelMapper.map(airport, AirportDTO.class);
    }

    public Airport convertToEntity(AirportDTO airportDTO) {
        return modelMapper.map(airportDTO, Airport.class);
    }

}
