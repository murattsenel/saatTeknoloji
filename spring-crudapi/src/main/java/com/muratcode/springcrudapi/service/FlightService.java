package com.muratcode.springcrudapi.service;


import com.muratcode.springcrudapi.domain.Airport;
import com.muratcode.springcrudapi.domain.AirportDTO;
import com.muratcode.springcrudapi.domain.Flight;
import com.muratcode.springcrudapi.domain.FlightDTO;
import com.muratcode.springcrudapi.mapper.ModelMapperService;
import com.muratcode.springcrudapi.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    private  final ModelMapperService modelMapperService;

    public FlightDTO save(FlightDTO flightDTO) {
        Flight flight=  this.modelMapperService.forRequest().map(flightDTO,Flight.class);
        return this.modelMapperService.forResponse().map(flightRepository.save(flight), FlightDTO.class);
    }
    public void delete(Long id) throws Exception {
       Optional<Flight> flight = flightRepository.findById(id);
       if(flight.isPresent()){
           flightRepository.deleteById(id);
       }else{
           throw new Exception("Silinmek istenen uçuş kaydı bulunamadı!");
       }
    }

    public FlightDTO findById(Long id) throws Exception {
        return  this.modelMapperService.forResponse().map(flightRepository.findById(id), FlightDTO.class);
    }

    public List<FlightDTO> getAll() {
        List<Flight> flightList = flightRepository.findAll();
        return flightList
                .stream()
                .map(flight -> this.modelMapperService.forResponse().map(flight,FlightDTO.class))
                .collect(Collectors.toList());
    }
}
