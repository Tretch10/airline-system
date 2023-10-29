package com.idenu.flightservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "flight_info")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int flightId;
    private String flightName;
    private String departureAirport;
    private String arrivalAirport;
    private String departureDate;
    private String arrivalDate;
    private String flightStatus;
    private int flightCapacity;


}
