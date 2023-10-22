package com.idenu.flightservice.service;

import com.idenu.flightservice.exception.ResourceNotFoundException;
import com.idenu.flightservice.model.Flight;
import com.idenu.flightservice.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public Flight getFlightByFlightId(String flightId) {
        log.info("Checking database if flight ID exist");
        Flight flight = flightRepository.findByFlightId(flightId);
        log.info("flight retrieved!");
        return flight;
    }
}
