package com.idenu.passenger.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    private String flightId;
    private String departureAirport;
    private String arrivalAirport;
    private String departureDate;
    private String arrivalDate;
}
