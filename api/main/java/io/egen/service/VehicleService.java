package main.java.io.egen.service;

import main.java.io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Rama on 6/30/2017.
 */
public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findOne(String id);
    Vehicle create(Vehicle emp);
    Vehicle update(String id, Vehicle emp);
    void delete(String id);
}
