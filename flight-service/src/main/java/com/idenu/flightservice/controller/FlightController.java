package com.idenu.flightservice.controller;

import com.idenu.flightservice.model.Flight;
import com.idenu.flightservice.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight) {
        Flight returnedFlight = flightService.saveFlight(flight);
        log.info("created flight "+ returnedFlight.getFlightName() + " with id:"+ returnedFlight.getFlightId());
        return new ResponseEntity<>(returnedFlight, HttpStatus.CREATED);
    }
}
