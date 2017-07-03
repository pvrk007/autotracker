package main.java.io.egen.repository;

import main.java.io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Rama on 6/30/2017.
 */
public interface VehicleRepository {
    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle create(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    void delete(Vehicle vehicle);
}
