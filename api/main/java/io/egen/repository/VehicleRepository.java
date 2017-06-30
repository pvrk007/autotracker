package main.java.io.egen.repository;

import main.java.io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Rama on 6/30/2017.
 */
public interface VehicleRepository {
    List<Vehicle> findAll();

    Vehicle findOne(String id);

    Vehicle findByEmail(String email);

    Vehicle create(Vehicle emp);

    Vehicle update(Vehicle emp);

    void delete(Vehicle emp);
}
