package com.idenu.passenger.service.repository;

import com.idenu.passenger.service.model.Address;
import com.idenu.passenger.service.model.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class PassengerRepositoryTest {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindPassengerByPassengerId() {
        Passenger passenger = new Passenger();
        passenger.setPassengerId(1);
        passenger.setFirstName("Test");
        passenger.setLastName("Flow");
        passenger.setEmail("testflow@gmail.com");
        passenger.setFlightId("FL123");
        Address address = new Address();
        address.setId(1);
        address.setStreet("1 Transylvania Ave");
        address.setCity("Metropolis");
        address.setState("XX");
        passenger.setAddress(address);

        entityManager.merge(passenger);
       // entityManager.persist(address);
        entityManager.flush();

        Passenger returnedPassenger = passengerRepository.findByPassengerId(1);

        //Assertion
        assertEquals(1, returnedPassenger.getPassengerId());
        assertEquals("Test", returnedPassenger.getFirstName());
        assertEquals("Flow", returnedPassenger.getLastName());
        assertEquals("testflow@gmail.com", returnedPassenger.getEmail());
        assertEquals("FL123", returnedPassenger.getFlightId());
        assertEquals("1 Transylvania Ave", returnedPassenger.getAddress().getStreet());
        assertEquals("Metropolis", returnedPassenger.getAddress().getCity());
        assertEquals("XX", returnedPassenger.getAddress().getState());


    }
}
