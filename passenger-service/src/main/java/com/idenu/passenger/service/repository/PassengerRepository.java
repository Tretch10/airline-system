package com.idenu.passenger.service.repository;

import com.idenu.passenger.service.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    Passenger findByPassengerId(int id);
}
