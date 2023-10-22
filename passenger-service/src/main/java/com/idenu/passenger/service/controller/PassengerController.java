package com.idenu.passenger.service.controller;

import com.idenu.passenger.service.domain.PassengerInfoResponse;
import com.idenu.passenger.service.model.Passenger;
import com.idenu.passenger.service.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
@Slf4j
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @PostMapping()
    public ResponseEntity savePassenger(@RequestBody Passenger passenger) {
        Passenger createdPassenger = passengerService.savePassenger(passenger);
        log.info("Returning saved passenger response");
        return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public PassengerInfoResponse getPassengerAndFlight(@PathVariable(value = "id") int id) {
        return passengerService.getPassengerWithFlightInfo(id);
    }
}
