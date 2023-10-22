package com.idenu.flightservice.controller;

import com.idenu.flightservice.model.Flight;
import com.idenu.flightservice.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightByFlightId(@PathVariable(value = "id") String id){
        Flight flight = flightService.getFlightByFlightId(id);
        log.info("returning flight with id: "+ id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
}
