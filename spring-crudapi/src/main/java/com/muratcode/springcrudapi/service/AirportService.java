package com.muratcode.springcrudapi.service;

import com.muratcode.springcrudapi.domain.Airport;
import com.muratcode.springcrudapi.domain.AirportDTO;
import com.muratcode.springcrudapi.domain.Flight;
import com.muratcode.springcrudapi.mapper.ModelMapperService;
import com.muratcode.springcrudapi.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    private  final ModelMapperService modelMapperService;
    public AirportDTO save(AirportDTO airportDTO) {
        Airport airport=  this.modelMapperService.forRequest().map(airportDTO,Airport.class);
        return this.modelMapperService.forResponse().map(airportRepository.save(airport), AirportDTO.class);
    }

    public void delete(Long id) throws Exception {
        Optional<Airport> airport = airportRepository.findById(id);
        if(airport.isPresent()){
            airportRepository.deleteById(id);
        }else{
            throw new Exception("Silinmek istenen airport bulunamadı!");
        }
    }
    public AirportDTO findById(Long id) throws Exception {
        return  this.modelMapperService.forResponse().map(airportRepository.findById(id), AirportDTO.class);
    }

    public List<AirportDTO> getAll() {
        List<Airport> airportList = airportRepository.findAll();
        return airportList
                .stream()
                .map(airport -> this.modelMapperService.forResponse().map(airport,AirportDTO.class))
                .collect(Collectors.toList());

    }
}
