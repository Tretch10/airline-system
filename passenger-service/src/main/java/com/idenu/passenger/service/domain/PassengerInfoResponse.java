package com.idenu.passenger.service.domain;

import com.idenu.passenger.service.model.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerInfoResponse {

    private Passenger passenger;
    private Flight flight;
}
