package com.idenu.passenger.service.service;

import com.idenu.passenger.service.domain.Flight;
import com.idenu.passenger.service.domain.PassengerInfoResponse;
import com.idenu.passenger.service.model.Passenger;
import com.idenu.passenger.service.repository.PassengerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PassengerService {

    private static final String FLIGHT_SERVICE_URL = "http://localhost:8081/flight/";
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private RestTemplate restTemplate;




    public Passenger savePassenger(Passenger passenger) {
        log.info("Saving passenger in database");
       Passenger savedPassenger = passengerRepository.save(passenger);
       log.info("Passenger saved successfully!");
       return savedPassenger;
    }

    public PassengerInfoResponse getPassengerWithFlightInfo(int id) {
        PassengerInfoResponse passengerInfoResponse = new PassengerInfoResponse();
        log.info("Retrieving passenger info from db");
        Passenger passenger = passengerRepository.findByPassengerId(id);
        log.info("Calling flight service to get flight information for passenger id: "+ id);
        Flight flight = restTemplate.getForObject(FLIGHT_SERVICE_URL+passenger.getFlightId(), Flight.class);
        log.info(String.format("Successfully retrieved flight info for passenger id %d with flight id %s", id, passenger.getFlightId()));
        passengerInfoResponse.setPassenger(passenger);
        passengerInfoResponse.setFlight(flight);

        return passengerInfoResponse;

    }
}
